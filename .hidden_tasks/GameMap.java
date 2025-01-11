import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GameMap {
    private int rows;
    private int cols;
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void loadFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "MAP":
                        this.rows = Integer.parseInt(parts[1]);
                        this.cols = Integer.parseInt(parts[2]);
                        break;
                    case "PLAYER":
                        this.player = new Player(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                        break;
                    case "ENEMY":
                        enemies.add(new Enemy(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                        break;
                    case "ITEM":
                        items.add(new Item(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                        break;
                    default:
                        System.out.println("Unknown configuration line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Configuration file not found: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in configuration file.");
        }
    }

    public void movePlayer(String direction) {
        player.move(direction, rows, cols);
        checkForItemCollection();
        checkForEnemyCollision();
    }

    private void checkForItemCollection() {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (player.getX() == item.getX() && player.getY() == item.getY()) {
                player.updateScore(item.getScoreValue());
                iterator.remove();
                System.out.println("Item collected! Current score: " + player.getScore());
            }
        }
    }

    private void checkForEnemyCollision() {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                player.reduceHealth(20);
                System.out.println("You collided with an enemy! Health remaining: " + player.getHealth());
                if (!player.isAlive()) {
                    System.out.println("Game Over! You lost all your health.");
                }
            }
        }
    }

    public void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.moveRandomly(rows, cols);
        }
    }

    public boolean allItemsCollected() {
        return items.isEmpty();
    }

    public Player getPlayer() {
        return this.player;
    }

    public void renderMap() {
        char[][] map = new char[rows][cols];
        for (char[] row : map) {
            Arrays.fill(row, '.');
        }

        map[player.getX()][player.getY()] = 'P';

        for (Enemy enemy : enemies) {
            map[enemy.getX()][enemy.getY()] = 'E';
        }

        for (Item item : items) {
            map[item.getX()][item.getY()] = 'I';
        }

        for (char[] row : map) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}