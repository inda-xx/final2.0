// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        GameMap gameMap = new GameMap();
        gameMap.loadFromFile("game_config.txt");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            gameMap.renderMap();
            // Display player health and score here
            // Prompt the user to enter a move

            String direction = scanner.nextLine();

            gameMap.movePlayer(direction);
            gameMap.moveEnemies();

            // Check player status and game conditions
            // End game with appropriate messages if conditions are met
        }

        scanner.close();
    }
}

// GameMap.java
import java.util.Map;

public class GameMap {
    public void loadFromFile(String fileName) {
        // Load game configuration from the file
    }

    public void renderMap() {
        // Render the map
    }

    public Player getPlayer() {
        // Return the player object
        return null; // Placeholder
    }

    public void movePlayer(String direction) {
        // Move the player based on the direction
    }

    public void moveEnemies() {
        // Move enemies within the map
    }

    public boolean allItemsCollected() {
        // Check if all items have been collected
        return false; // Placeholder
    }
}

// Player.java
public class Player {
    public int getHealth() {
        // Return player's health
        return 0; // Placeholder
    }

    public int getScore() {
        // Return player's score
        return 0; // Placeholder
    }

    public boolean isAlive() {
        // Check if player is alive
        return false; // Placeholder
    }
}