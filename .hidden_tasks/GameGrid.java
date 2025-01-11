import java.util.List;
import java.util.ArrayList;

public class GameGrid {
    private int width;
    private int height;
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void populateGridFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(": ");
            switch (parts[0]) {
                case "Grid":
                    String[] dimensions = parts[1].split("x");
                    width = Integer.parseInt(dimensions[0]);
                    height = Integer.parseInt(dimensions[1]);
                    break;
                case "Player":
                    String[] playerPos = parts[1].split(",");
                    int playerX = Integer.parseInt(playerPos[0]);
                    int playerY = Integer.parseInt(playerPos[1]);
                    player = new Player(playerX, playerY);
                    break;
                case "Enemy":
                    String[] enemyPos = parts[1].split(",");
                    int enemyX = Integer.parseInt(enemyPos[0]);
                    int enemyY = Integer.parseInt(enemyPos[1]);
                    enemies.add(new Enemy(enemyX, enemyY));
                    break;
                case "Item":
                    String[] itemData = parts[1].split(",");
                    int itemX = Integer.parseInt(itemData[0]);
                    int itemY = Integer.parseInt(itemData[1]);
                    int points = Integer.parseInt(itemData[2]);
                    items.add(new Item(itemX, itemY, points));
                    break;
            }
        }
        reader.close();
    }

    public Player getPlayer() {
        return player;
    }

    public List<Item> getItems() {
        return items;
    }

    public void movePlayer(String direction) {
        switch (direction.toUpperCase()) {
            case "W":
                if (player.getX() > 0) player.moveUp();
                break;
            case "A":
                if (player.getY() > 0) player.moveLeft();
                break;
            case "S":
                if (player.getX() < height - 1) player.moveDown();
                break;
            case "D":
                if (player.getY() < width - 1) player.moveRight();
                break;
            default:
                System.out.println("Invalid input! Use W (up), A (left), S (down), D (right).");
        }
    }

    public void drawGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (player.getX() == i && player.getY() == j) {
                    System.out.print("P ");
                } else if (isEnemyAt(i, j)) {
                    System.out.print("E ");
                } else if (isItemAt(i, j)) {
                    System.out.print("I ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private boolean isEnemyAt(int x, int y) {
        for (Enemy enemy : enemies) {
            if (enemy.getX() == x && enemy.getY() == y) {
                return true;
            }
        }
        return false;
    }

    private boolean isItemAt(int x, int y) {
        for (Item item : items) {
            if (item.getX() == x && item.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCollisions() {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                System.out.println("Game Over! You collided with an enemy.");
                return true;
            }
        }

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (player.getX() == item.getX() && player.getY() == item.getY()) {
                player.addScore(item.getPoints());
                System.out.println("You collected an item worth " + item.getPoints() + " points!");
                iterator.remove();
            }
        }

        return false;
    }
}