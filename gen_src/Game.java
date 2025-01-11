// File: Game.java
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        GameGrid grid = new GameGrid();
        try {
            grid.populateGridFromFile("gameData.txt");
            Scanner scanner = new Scanner(System.in);

            boolean isGameOver = false;
            while (!isGameOver) {
                grid.drawGrid();
                System.out.println("Your score: " + grid.getPlayer().getScore());
                System.out.print("Enter move (W/A/S/D): ");
                String move = scanner.nextLine();
                grid.movePlayer(move);

                isGameOver = grid.checkCollisions();

                if (grid.getItems().isEmpty()) {
                    System.out.println("Congratulations! You collected all items!");
                    isGameOver = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading game data file: " + e.getMessage());
        }
    }
}

// File: GameGrid.java
import java.io.IOException;
import java.util.List;

public class GameGrid {
    public void populateGridFromFile(String fileName) throws IOException {
        // Populate the game grid from the provided file
    }

    public void drawGrid() {
        // Draw the current state of the game grid
    }

    public void movePlayer(String move) {
        // Update the player's position based on the move
    }

    public boolean checkCollisions() {
        // Check for collisions or end game conditions and return the result
        return false;
    }

    public Player getPlayer() {
        // Return the player instance
        return null;
    }

    public List<Item> getItems() {
        // Return the list of remaining items on the grid
        return null;
    }
}

// File: Player.java
public class Player {
    public int getScore() {
        // Return the player's current score
        return 0;
    }
}

// File: Item.java
public class Item {
    // Item class to represent collectible items on the grid
}