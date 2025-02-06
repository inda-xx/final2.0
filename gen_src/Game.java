import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int GRID_SIZE = 10;

    public static void main(String[] args) {
        Player player = new Player(0, 0);
        List<Enemy> enemies = GameLoader.loadEnemies("enemies.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Score: " + player.getScore());
            System.out.print("Enter move (w/a/s/d or 'q' to quit): ");
            String move = scanner.nextLine();

            switch (move) {

                case "w": player.move(0, -1, GRID_SIZE); break;
                case "s": player.move(0, 1, GRID_SIZE); break;
                case "a": player.move(-1, 0, GRID_SIZE); break;
                case "d": player.move(1, 0, GRID_SIZE); break;
                case "q": System.out.println("Game Over!"); return;
                default: System.out.println("Invalid move");
            }

            GameLogic.moveEnemies(enemies, GRID_SIZE);

            if (GameLogic.checkCollision(player, enemies)) {
                System.out.println("You were caught by an enemy! Game Over!");
                break;
            }

            if (player.getScore() >= 10) {
                System.out.println("Congratulations! You win!");
                break;
            }

        }
        scanner.close();
    }
}