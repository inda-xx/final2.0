import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private char[][] grid = new char[10][10];

    public void initializeGame() {
        // Initialize player
        player = new Player(1, 1);

        // Initialize enemies
        enemies.add(new Enemy(3, 4));
        enemies.add(new Enemy(7, 2));

        // Initialize items
        items.add(new Item(2, 5));
        items.add(new Item(8, 8));

        // Display initial grid
        updateGrid();
        displayGrid();
    }

    private void updateGrid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = '.';
            }
        }

        // Place player
        grid[player.getX()][player.getY()] = 'P';

        // Place enemies
        for (Enemy enemy : enemies) {
            grid[enemy.getX()][enemy.getY()] = 'E';
        }

        // Place items
        for (Item item : items) {
            grid[item.getX()][item.getY()] = 'C';
        }
    }

    private void displayGrid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isGameOver() {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                System.out.println("Game Over! You collided with an enemy.");
                return true;
            }
        }
        return false;
    }

    private boolean isGameWon() {
        return items.isEmpty();
    }

    private void checkItemCollection() {
        items.removeIf(item -> {
            if (player.getX() == item.getX() && player.getY() == item.getY()) {
                player.increaseScore();
                System.out.println("Item collected! Current score: " + player.getScore());
                return true;
            }
            return false;
        });
    }

    private void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.moveRandomly();
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("Enter your move (UP, DOWN, LEFT, RIGHT): ");
            command = scanner.nextLine();

            player.move(command);
            checkItemCollection();

            if (isGameWon()) {
                System.out.println("Congratulations! You collected all items and won the game!");
                break;
            }

            moveEnemies();

            if (isGameOver()) {
                break;
            }

            updateGrid();
            displayGrid();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame();
        game.startGame();
    }
}