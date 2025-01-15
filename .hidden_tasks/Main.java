import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            GameWorld gameWorld = new GameWorld(0, 0);
            gameWorld.loadGameWorld("gameworld.txt");

            Player player = GameSetup.loadPlayer("player.txt", gameWorld.getWidth(), gameWorld.getHeight());
            List<Enemy> enemies = GameSetup.loadEnemies("enemies.txt", gameWorld.getWidth(), gameWorld.getHeight());

            boolean gameOver = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the game!");
            while (!gameOver) {
                System.out.println("Current Position: (" + player.getX() + "," + player.getY() + ")");
                System.out.println("Score: " + player.getScore());
                System.out.print("Enter move (up, down, left, right): ");
                String move = scanner.nextLine();
                player.move(move, gameWorld.getWidth(), gameWorld.getHeight());

                if (gameWorld.checkCollision(player, enemies)) {
                    System.out.println("You collided with an enemy! Game Over.");
                    gameOver = true;
                }

                if (gameWorld.checkPointCollected(player)) {
                    player.increaseScore(10);
                    System.out.println("Point collected! Score increased by 10.");
                }

                if (gameWorld.checkBonusPointCollected(player)) {
                    player.increaseScore(50);
                    System.out.println("Bonus Point collected! Score increased by 50.");
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}