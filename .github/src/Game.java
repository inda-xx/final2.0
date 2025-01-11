import java.util.Scanner;

/**
 * The Game class is the main class for the game
 *
 * @author Gabriel Skoglund
 */
public class Game {
    private static GameState state;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * A simple arrow indicating that the program is waiting for player input.
     * Why not try replacing this symbol with something else that you prefer?
     */
    private static final String PROMPT = "> ";

    public static void main(String[] args) {
        generateRooms();
        printWelcomeMessage();

        // Main game loop, keep reading player input and update game state based on this.
        // This loop should be changed to end once the player has won.
        while (true) {
            String command = getCommand();
            CommandParser.parse(command, state);
        }
    }

    private static String getCommand() {
        System.out.print(PROMPT);
        // Read a line of user input from the terminal
        String command = scanner.nextLine();
        // Remove the prompt from the start of the line
        command = command.replaceFirst(PROMPT, "");
        return command;
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to The Colossal KTH Adventure, the exciting new text based adventure game.");
        state.getCurrentRoom().lookAround();
        CommandParser.printHelpMessage();
    }

    /**
     * Generate the rooms needed for a very basic version of the game.
     * In your version of the game, you should remove this method and read your own rooms from a file instead.
     */
    private static void generateRooms() {
        // Create a set of rooms
        Room start = new Room("You are at the Tekniska Högskolan subway station. You look around for " +
                "someone handing out free samples, but there don't seem to be any today.");
        Room borggarden = new Room("You are outside in borggården, there is a cold wind blowing.");
        Room f1 = new Room("You are in the main F1 lecture hall, there is a very advanced " +
                "math lecture going on. You don't understand anything.");
        Room e43 = new Room("You are in an empty classroom in the E building. Someone has written " +
                "\"I love INDA\" on the blackboard");
        Room gul = new Room("You are in the Gul computer lab. Someone has left a computer running with " +
                "a halfway finished INDA assignment open in the editor. You are tempted to look but manage " +
                "to resist the urge.");

        // Create exits leading from one room to another
        start.addExit("north", borggarden);
        borggarden.addExit("north", f1);
        borggarden.addExit("west", e43);
        borggarden.addExit("south", start);
        f1.addExit("south", borggarden);
        e43.addExit("east", borggarden);
        e43.addExit("up", gul);
        gul.addExit("down", e43);

        // Set the starting room
        state = new GameState(start);
    }

}