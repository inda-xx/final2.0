import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        GameMap gameMap = new GameMap();
        gameMap.loadFromFile("game_config.txt");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            gameMap.renderMap();
            System.out.println("Health: " + gameMap.getPlayer().getHealth() + " | Score: " + gameMap.getPlayer().getScore());
            System.out.println("Enter move (up, down, left, right): ");
            String direction = scanner.nextLine();

            gameMap.movePlayer(direction);
            gameMap.moveEnemies();

            if (!gameMap.getPlayer().isAlive()) {
                running = false;
                System.out.println("Game Over!");
            } else if (gameMap.allItemsCollected()) {
                running = false;
                System.out.println("You Win! Final Score: " + gameMap.getPlayer().getScore());
            }
        }

        scanner.close();
    }
}