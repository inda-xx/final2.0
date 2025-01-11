public class CommandParser {

    /**
     * Parse the command and execute the corresponding action on the game state.
     * @param command the user input command
     * @param state the current game state
     */
    public static void parse(String command, GameState state) {
        // Split the input command into parts
        // Extract the action from the command
        // Use a switch statement to handle different actions

        switch (/* Action */) {
            case "go":
                // Handle "go [direction]" command
                break;

            case "look":
                // Handle "look" command
                break;

            case "help":
                // Handle "help" command
                break;

            case "quit":
                // Handle "quit" command
                break;

            default:
                // Handle unknown commands
                break;
        }
    }

    /**
     * Print the help message with a list of available commands.
     */
    public static void printHelpMessage() {
        // Print information about available commands
    }
}