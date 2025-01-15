import java.util.Map;
import java.util.HashMap;

public class CommandParser {
    private static final Map<String, CommandAction> commands = new HashMap<>();

    static {
        commands.put("go", new CommandAction() {
            @Override
            public void execute(String argument, GameState state) {
                Room nextRoom = state.getCurrentRoom().go(argument);
                if (nextRoom != null) {
                    state.setCurrentRoom(nextRoom);
                    nextRoom.lookAround();
                }
            }
        });

        commands.put("look", new CommandAction() {
            @Override
            public void execute(String argument, GameState state) {
                state.getCurrentRoom().lookAround();
            }
        });

        commands.put("help", new CommandAction() {
            @Override
            public void execute(String argument, GameState state) {
                printHelpMessage();
            }
        });
    }

    public static void parse(String commandLine, GameState state) {
        String[] parts = commandLine.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        CommandAction action = commands.get(command);
        if (action != null) {
            action.execute(argument, state);
        } else {
            System.out.println("Unknown command! Type 'help' for a list of commands.");
        }
    }

    public static void printHelpMessage() {
        System.out.println("Available commands:");
        System.out.println(" - go <direction>: Move to a different room.");
        System.out.println(" - look: Look around the current room.");
        System.out.println(" - help: Display this help message.");
    }
}







public interface CommandAction {
    void execute(String argument, GameState state);
}