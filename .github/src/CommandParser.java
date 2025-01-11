/**
 * The CommandParser class attempts to parse ("understand") a command from the user.
 * A command is defined to be of the form [command word] [modifier], where the modifier
 * is optional for certain commands.
 * As an example, the command "go north" will be parsed with the command word "go" and the
 * modifier "north". This structure is of course not set in stone, so feel free to modifiy
 * it further. You could perhaps add a second modifier so that the user could enter
 * "go north quickly".
 * @author Gabriel Skoglund
 */
public class CommandParser {

    /**
     * Attempt to parse a command string from the player. If the command is valid,
     * it will be executed. For instance, if the command is "go north", and the
     * current room has an exit to the north, the effect will be to move the player
     * to the room to the north.
     *
     * @param command the string entered by the player
     * @param state   the current state that the game is in. This includes for instance
     *                the current room that the player is in.
     */
    public static void parse(String command, GameState state) {
        // Perform some initial handling of the command, removing any whitespace before
        // and after, turning it to lower case and splitting the command
        // on one or more whitespace characters
        String[] splitCommand = command.trim().toLowerCase().split("\\s+");

        // Check so that the player has entered something
        if (splitCommand.length < 1) {
            printInvalidCommandMessage();
            return;
        }

        // Attempt to match the player input to a command and execute it
        switch (splitCommand[0]) {
            case "go" -> executeGoCommand(splitCommand, state);
            case "look" -> executeLookCommand(state);
            case "help" -> printHelpMessage();
            default -> printInvalidCommandMessage();
        }
    }

    private static void executeGoCommand(String[] splitCommand, GameState state) {
        // Check so that we have a direction word
        if (splitCommand.length < 2) {
            printMissingModifierMessage("go");
        } else {
            // Attempt to leave the current room in the given direction
            Room currentRoom = state.getCurrentRoom();
            Room newRoom = currentRoom.go(splitCommand[1]);
            if (newRoom != null) {
                state.setCurrentRoom(newRoom);
                newRoom.lookAround();
            }
        }
    }

    private static void executeLookCommand(GameState state) {
        state.getCurrentRoom().lookAround();
    }

    private static void printInvalidCommandMessage() {
        System.out.println("I'm sorry, that's not a valid command. " +
                           "Type \"help\" for information about commands.");
    }

    private static void printMissingModifierMessage(String command) {
        System.out.println("I'm sorry, the \"" + command + "\" command requires one more command word. " +
                           "Type \"help\" for information about commands.");
    }

    /**
     * Print out the commands available to the player.
     */
    public static void printHelpMessage() {
        System.out.println("Your available commands are:");
        System.out.println("    \"go <direction>\" - Attempt to leave the current room in the given direction.");
        System.out.println("    \"look\" - Look around the current room");
        System.out.println("    \"help\" - Print this useful help message.");
    }
}