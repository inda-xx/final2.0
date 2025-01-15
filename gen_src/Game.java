Game.java
```java
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private List<Enemy> enemies;
    private List<PowerUp> powerUps;

    public Game(Player player, List<Enemy> enemies, List<PowerUp> powerUps) {
        // Initialize game objects
    }

    public void start() {
        // Game loop
        // - Handle input
        // - Update game state
        // - Print game status
    }

    private void checkPowerUpCollision() {
        // Check for collisions with power-ups and handle them
    }
}
```