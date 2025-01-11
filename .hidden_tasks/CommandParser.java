public class CommandParser {

    /**
     * Parse the command and execute the corresponding action on the game state.
     * @param command the user input command
     * @param state the current game state
     */
    public static void parse(String command, GameState state) {
        String[] parts = command.split(" ");
        String action = parts[0].toLowerCase();

        switch (action) {
            case "go":
                if (parts.length > 1) {
                    String direction = parts[1].toLowerCase();
                    Room currentRoom = state.getCurrentRoom();
                    Room nextRoom = currentRoom.go(direction);
                    if (nextRoom != null) {
                        state.setCurrentRoom(nextRoom);
                        nextRoom.lookAround();
                    }
                } else {
                    System.out.println("Go where?");
                }
                break;

            case "look":
                state.getCurrentRoom().lookAround();
                break;

            case "help":
                printHelpMessage();
                break;

            case "quit":
                System.out.println("Thanks for playing! Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("I don't understand that command.");
                break;
        }
    }

    /**
     * Print the help message with a list of available commands.
     */
    public static void printHelpMessage() {
        System.out.println("Available commands:");
        System.out.println("  go [direction] - Move to another room in the specified direction.");
        System.out.println("  look - Look around the current room.");
        System.out.println("  help - Show this help message.");
        System.out.println("  quit - Exit the game.");
    }
}