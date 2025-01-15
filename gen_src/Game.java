// File: Game.java
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static GameState state;
    private static Scanner scanner = new Scanner(System.in);
    private static final String PROMPT = "> ";

    public static void main(String[] args) {
        generateRoomsFromFile();
        printWelcomeMessage();

        while (true) {
            String command = getCommand();
            CommandParser.parse(command, state);
        }
    }

    private static String getCommand() {
        System.out.print(PROMPT);
        String command = scanner.nextLine();
        // Additional logic would process the command
        return command;
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to The Colossal KTH Adventure.");
        // Logic to handle welcome messages
    }

    private static void generateRoomsFromFile() {
        HashMap<String, Room> worldModel = new HashMap<>();
        // Logic to read rooms from a file and build the world model
    }
}

// File: GameState.java
public class GameState {
    private Room currentRoom;

    public GameState(Room startingRoom) {
        // Logic to initialize the game state
    }

    public Room getCurrentRoom() {
        // Returns the current room
        return null; // Placeholder
    }
}

// File: Room.java
import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        // Logic to initialize the room
    }

    public void addExit(String direction, Room room) {
        // Logic to add an exit to this room
    }

    public void lookAround() {
        // Logic for describing the room
    }
}

// File: CommandParser.java
public class CommandParser {
    public static void parse(String command, GameState state) {
        // Logic to process commands
    }

    public static void printHelpMessage() {
        // Prints a help message
    }
}