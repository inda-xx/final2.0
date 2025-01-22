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