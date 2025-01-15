package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testRoomCreationFromFile() throws IOException {
        // Create a temporary file with test room and exit data
        File tempFile = File.createTempFile("testRooms", ".txt");
        tempFile.deleteOnExit();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Room;start;This is the starting room.\n");
            writer.write("Room;end;This is the ending room.\n");
            writer.write("Exit;start;north;end\n");
        }

        // Redirect the input file to the temporary file
        System.setIn(new FileInputStream(tempFile.getPath()));

        Game.generateRoomsFromFile();

        GameState gameState = reflectGameState();
        assertNotNull("Game state should not be null after room generation.", gameState);
        Room startRoom = gameState.getCurrentRoom();
        assertNotNull("Starting room should not be null.", startRoom);
        assertEquals("Room description does not match.", "This is the starting room.", startRoom.description);

        Room endRoom = startRoom.go("north");
        assertNotNull("End room should not be null when moving north.", endRoom);
        assertEquals("Room description does not match.", "This is the ending room.", endRoom.description);
    }

    @Test
    public void testInvalidDirectionPrintsErrorMessage() {
        Room testRoom = new Room("Test room.");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Room result = testRoom.go("east");
        assertNull("There should be no room to the east.", result);

        String output = outputStream.toString();
        assertTrue("Error message should mention invalid direction.",
                output.contains("You can't go that way!"));
        assertTrue("Error message should mention available exits.",
                output.contains("There are exits in the directions:"));
    }

    @Test
    public void testLookAroundPrintsRoomDescriptionAndExits() {
        Room testRoom = new Room("This is a test room.");
        testRoom.addExit("north", new Room("Another room."));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        testRoom.lookAround();

        String output = outputStream.toString();
        assertTrue("Room description should be printed.", output.contains("This is a test room."));
        assertTrue("Room exits should be printed.", output.contains("north"));
    }

    @Test
    public void testHelpCommandDisplaysAvailableCommands() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CommandParser.printHelpMessage();

        String helpMessage = outputStream.toString();
        assertTrue("Help message should list 'go <direction>' command.", helpMessage.contains("go <direction>"));
        assertTrue("Help message should list 'look' command.", helpMessage.contains("look"));
        assertTrue("Help message should list 'help' command.", helpMessage.contains("help"));
    }

    @Test
    public void testMoveToAnotherRoom() {
        Room startRoom = new Room("Start room.");
        Room endRoom = new Room("End room.");
        startRoom.addExit("north", endRoom);

        GameState state = new GameState(startRoom);
        CommandParser.parse("go north", state);

        assertEquals("Player should be in the end room after moving north.", endRoom, state.getCurrentRoom());
    }

    @Test
    public void testInvalidCommandPrintsError() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GameState state = new GameState(new Room("A room."));
        CommandParser.parse("invalidcommand", state);

        String output = outputStream.toString();
        assertTrue("Error message should mention unknown command.",
                output.contains("Unknown command! Type 'help' for a list of commands."));
    }

    @Test
    public void testBoundaryConditionsWhenMoving() {
        Room loneRoom = new Room("Single room with no exits.");
        GameState state = new GameState(loneRoom);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CommandParser.parse("go south", state);

        String output = outputStream.toString();
        assertNotNull("Game state should remain valid when hitting the boundary.", state.getCurrentRoom());
        assertEquals("Player should still be in the same room.", loneRoom, state.getCurrentRoom());
        assertTrue("Error message should indicate no exit.",
                output.contains("You can't go that way!"));
    }

    @Test
    public void testRoomChaining() {
        Room firstRoom = new Room("First room.");
        Room secondRoom = new Room("Second room.");
        Room thirdRoom = new Room("Third room.");
        firstRoom.addExit("north", secondRoom);
        secondRoom.addExit("east", thirdRoom);

        GameState state = new GameState(firstRoom);
        CommandParser.parse("go north", state);
        assertEquals(secondRoom, state.getCurrentRoom());

        CommandParser.parse("go east", state);
        assertEquals(thirdRoom, state.getCurrentRoom());
    }

    private GameState reflectGameState() {
        try {
            Field field = Game.class.getDeclaredField("state");
            field.setAccessible(true);
            return (GameState) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}