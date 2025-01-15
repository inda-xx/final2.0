import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private static final int GRID_SIZE = 10;
    private static boolean isGameOver = false;

    public static void main(String[] args) {
        Player player = new Player("Hero", 5, 5);
        List<Enemy> enemies = loadEnemiesFromFile("enemies.csv");
        List<Item> items = spawnItems(5, GRID_SIZE);

        System.out.println("Welcome to the Grid Game!");
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            System.out.println("\nPlayer Health: " + player.getHealth());
            System.out.println("Player Score: " + player.getScore());
            System.out.println("Player Position: (" + player.getPositionX() + ", " + player.getPositionY() + ")");
            System.out.print("Move (up, down, left, right): ");
            String direction = scanner.nextLine();

            switch (direction.toLowerCase()) {
                case "up":
                    player.move(0, -1, GRID_SIZE);
                    break;
                case "down":
                    player.move(0, 1, GRID_SIZE);
                    break;
                case "left":
                    player.move(-1, 0, GRID_SIZE);
                    break;
                case "right":
                    player.move(1, 0, GRID_SIZE);
                    break;
                default:
                    System.out.println("Invalid direction");
            }

            checkItemCollection(player, items);
            checkEnemyInteraction(player, enemies);

            if (player.getHealth() <= 0) {
                isGameOver = true;
                System.out.println("Game Over! You have run out of health.");
            }
        }

        System.out.println("Final Score: " + player.getScore());
    }

    private static List<Enemy> loadEnemiesFromFile(String fileName) {
        List<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int health = Integer.parseInt(data[1]);
                int positionX = Integer.parseInt(data[2]);
                int positionY = Integer.parseInt(data[3]);
                enemies.add(new Enemy(name, health, positionX, positionY));
            }
        } catch (Exception e) {
            System.out.println("Error reading enemy file: " + e.getMessage());
        }
        return enemies;
    }

    private static List<Item> spawnItems(int count, int gridSize) {
        List<Item> items = new ArrayList<>();
        Random random = new Random();
        while (items.size() < count) {
            int x = random.nextInt(gridSize);
            int y = random.nextInt(gridSize);
            boolean positionOccupied = items.stream().anyMatch(i -> i.getPositionX() == x && i.getPositionY() == y);

            if (!positionOccupied) {
                items.add(new Item("Gold Coin", 10, x, y));
            }
        }
        return items;
    }

    private static void checkItemCollection(Player player, List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (player.getPositionX() == item.getPositionX() && player.getPositionY() == item.getPositionY()) {
                System.out.println("Collected: " + item.getName() + " (+ " + item.getPoints() + " points)");
                player.updateScore(item.getPoints());
                items.remove(i);
                break;
            }
        }
    }

    private static void checkEnemyInteraction(Player player, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (player.getPositionX() == enemy.getPositionX() && player.getPositionY() == enemy.getPositionY()) {
                System.out.println("Encountered an enemy: " + enemy.getName() + " (-20 health)");
                player.takeDamage(20);
                break;
            }
        }
    }
}