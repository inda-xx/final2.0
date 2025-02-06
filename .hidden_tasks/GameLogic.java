import java.util.List;
import java.util.Random;

public class GameLogic {
    public static boolean checkCollision(Player player, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                return true;
            }
        }
        return false;
    }

    public static void moveEnemies(List<Enemy> enemies, int gridSize) {
        Random random = new Random();
        for (Enemy enemy : enemies) {
            int direction = random.nextInt(4);
            switch (direction) {
                case 0: enemy.move(0, -1, gridSize); break;
                case 1: enemy.move(0, 1, gridSize); break;
                case 2: enemy.move(-1, 0, gridSize); break;
                case 3: enemy.move(1, 0, gridSize); break;
            }
        }
    }
}