import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {
    private Player player;
    private List<Enemy> enemies;
    private List<Item> items;
    private GameState state;
    private int mapWidth;
    private int mapHeight;

    private Scanner scanner;

    public GameEngine(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.state = GameState.RUNNING;
    }

    public void loadObjects(List<GameObject> objects) {
        enemies.clear();
        items.clear();
        for (GameObject obj : objects) {
            if (obj instanceof Player) {
                this.player = (Player) obj;
            } else if (obj instanceof Enemy) {
                enemies.add((Enemy) obj);
            } else if (obj instanceof Item) {
                items.add((Item) obj);
            }
        }
    }

    public void run() {
        while (state != GameState.GAME_OVER) {
            render();
            handleInput();

            if (state == GameState.RUNNING) {
                checkItemCollisions();
                checkEnemyCollisions();
                if (player.getHealth() <= 0) {
                    System.out.println("You have died.");
                    state = GameState.GAME_OVER;
                }
                if (items.isEmpty()) {
                    System.out.println("Congratulations! You collected all the items!");
                    state = GameState.GAME_OVER;
                }
            }
        }
        System.out.println("Final Score: " + player.getScore());
    }

    private void handleInput() {
        System.out.print("Enter move (WASD), P: pause, R: resume, Q: quit: ");
        String input = scanner.nextLine().toUpperCase();
        if (input.isEmpty()) return;
        char command = input.charAt(0);

        switch (command) {
            case 'W': case 'A': case 'S': case 'D':
                if (state == GameState.RUNNING) {
                    player.move(command, mapWidth, mapHeight);
                }
                break;
            case 'P':
                if (state == GameState.RUNNING) {
                    state = GameState.PAUSED;
                    System.out.println("Game paused.");
                }
                break;
            case 'R':
                if (state == GameState.PAUSED) {
                    state = GameState.RUNNING;
                    System.out.println("Game resumed.");
                }
                break;
            case 'Q':
                System.out.println("Quitting game...");
                state = GameState.GAME_OVER;
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    private void checkEnemyCollisions() {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                System.out.println("You encountered an enemy!");
                player.setHealth(player.getHealth() - 1);
                System.out.println("Health: " + player.getHealth());
                break;
            }
        }
    }

    private void checkItemCollisions() {
        List<Item> collected = new ArrayList<>();
        for (Item item : items) {
            if (player.getX() == item.getX() && player.getY() == item.getY()) {
                player.collect(item);
                collected.add(item);
                System.out.println("Collected item worth " + item.getValue() + " points!");
            }
        }
        items.removeAll(collected);
    }

    private void render() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                if (player.getX() == x && player.getY() == y) {
                    System.out.print("P ");
                } else if (hasEnemyAt(x, y)) {
                    System.out.print("E ");
                } else if (hasItemAt(x, y)) {
                    System.out.print("I ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("Score: " + player.getScore() + "  Health: " + player.getHealth());
    }

    private boolean hasEnemyAt(int x, int y) {
        for (Enemy e : enemies) {
            if (e.getX() == x && e.getY() == y) return true;
        }
        return false;
    }

    private boolean hasItemAt(int x, int y) {
        for (Item i : items) {
            if (i.getX() == x && i.getY() == y) return true;
        }
        return false;
    }
}

// File: GameState.java
public enum GameState {
    RUNNING,
    PAUSED,
    GAME_OVER
}

// File: GameObject.java
public abstract class GameObject {
    protected int x;
    protected int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}