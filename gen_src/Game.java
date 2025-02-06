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
                case "w":
                case "s":
                case "a":
                case "d":
                    // Handle player movement
                    break;
                case "q":
                    // Handle game quitting
                    return;
                default:
                    // Handle invalid move
            }

            // Move enemies and check for collisions

            scanner.close();
        }
    }
}