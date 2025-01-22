// Game.java
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int gridSize = 5;
        GameWorld world = new GameWorld(gridSize);
        Player player = new Player("John", 0, 0);
        world.placePlayer(player);

        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Orc", 2, 2));
        enemies.add(new Enemy("Troll", 4, 4));

        for (Enemy enemy : enemies) {
            world.placeEnemy(enemy);
        }

        world.placeCollectibles(5);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            world.displayGrid();
            System.out.println("Score: " + player.getScore());
            System.out.print("Enter a move (up, down, left, right): ");
            String command = scanner.nextLine();

            int oldX = player.getX();
            int oldY = player.getY();
            player.move(command, gridSize);
            world.updatePlayerPosition(player, oldX, oldY);

            for (Enemy enemy : enemies) {
                int enemyOldX = enemy.getX();
                int enemyOldY = enemy.getY();
                enemy.move(gridSize);
                world.clearEnemyPosition(enemyOldX, enemyOldY);
                world.updateEnemyPosition(enemy);

                if (world.detectCollision(player, enemy)) {
                    System.out.println("You were caught by an enemy! Game over.");
                    return;
                }
            }

            if (player.getScore() >= 50) {
                System.out.println("Congratulations! You collected all coins and won!");
                return;
            }
        }
    }
}

// GameWorld.java
public class GameWorld {
    public GameWorld(int gridSize) {
        // Constructor
    }

    public void placePlayer(Player player) {
        // Method to place player
    }

    public void placeEnemy(Enemy enemy) {
        // Method to place enemy
    }

    public void placeCollectibles(int count) {
        // Method to place collectibles
    }

    public void displayGrid() {
        // Method to display grid
    }

    public void updatePlayerPosition(Player player, int oldX, int oldY) {
        // Update player's position on the grid
    }

    public void clearEnemyPosition(int x, int y) {
        // Clear enemy's old position
    }

    public void updateEnemyPosition(Enemy enemy) {
        // Update enemy's position on the grid
    }

    public boolean detectCollision(Player player, Enemy enemy) {
        // Detect collision between player and enemy
        return false;
    }
}

// Player.java
public class Player {
    public Player(String name, int x, int y) {
        // Constructor
    }

    public int getX() {
        // Return player's X position
        return 0;
    }

    public int getY() {
        // Return player's Y position
        return 0;
    }

    public void move(String direction, int gridSize) {
        // Move the player
    }

    public int getScore() {
        // Get the player's score
        return 0;
    }
}

// Enemy.java
public class Enemy {
    public Enemy(String name, int x, int y) {
        // Constructor
    }

    public int getX() {
        // Return enemy's X position
        return 0;
    }

    public int getY() {
        // Return enemy's Y position
        return 0;
    }

    public void move(int gridSize) {
        // Move the enemy
    }
}