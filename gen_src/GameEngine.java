// File: GameEngine.java
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
        // constructor logic
    }

    public void loadObjects(List<GameObject> objects) {
        // load objects and classify by type
    }

    public void run() {
        // main game loop
    }

    private void handleInput() {
        // read and process user input
    }

    private void checkEnemyCollisions() {
        // check if player collides with any enemies
    }

    private void checkItemCollisions() {
        // check if player collects any items
    }

    private void render() {
        // render the current game map
    }

    private boolean hasEnemyAt(int x, int y) {
        // check if enemy exists at position
        return false;
    }

    private boolean hasItemAt(int x, int y) {
        // check if item exists at position
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
        // constructor logic
    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }
}