// File: CommandParser.java
import java.util.Map;
import java.util.HashMap;

public class CommandParser {
    private static final Map<String, CommandAction> commands = new HashMap<>();

    static {
        // Register commands here (scaffolding provided, implementation omitted)
        commands.put("go", new CommandAction() {
            @Override
            public void execute(String argument, GameState state) {
                // Command logic for "go"
            }
        });

        commands.put("look", new CommandAction() {
            @Override
            public void execute(String argument, GameState state) {
                // Command logic for "look"
            }
        });

        commands.put("help", new CommandAction() {
            @Override
            public void execute(String argument, GameState state) {
                // Command logic for "help"
            }
        });
    }

    public static void parse(String commandLine, GameState state) {
        // Split the command line into its parts
        String[] parts = commandLine.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        // Process command if found
        CommandAction action = commands.get(command);
        if (action != null) {
            action.execute(argument, state);
        } else {
            System.out.println("Unknown command! Type 'help' for a list of commands.");
        }
    }

    public static void printHelpMessage() {
        // Print available commands
        System.out.println("Available commands:");
        System.out.println(" - go <direction>: Move to a different room.");
        System.out.println(" - look: Look around the current room.");
        System.out.println(" - help: Display this help message.");
    }
}

// File: CommandAction.java
public interface CommandAction {
    void execute(String argument, GameState state);
}

// Note: GameState and Room classes are referenced but not shown in this scaffold. Students may need to implement/support those separately.