// File: Main.java
import java.util.List;

public class Main {
    private static final int MAP_WIDTH = 5;
    private static final int MAP_HEIGHT = 5;

    public static void main(String[] args) {
        GameEngine engine = new GameEngine(MAP_WIDTH, MAP_HEIGHT);

        for (int level = 1; level <= 2; level++) {
            String levelFile = "level" + level + ".txt";
            List<GameObject> levelObjects = GameLoader.loadGame(levelFile);
            engine.loadObjects(levelObjects);
            System.out.println("=== Starting Level " + level + " ===");
            engine.run();
        }

        System.out.println("You completed all levels. Thanks for playing!");
    }
}