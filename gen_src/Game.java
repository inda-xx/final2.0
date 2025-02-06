import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int GRID_SIZE = 10;

    public static void main(String[] args) {
        Player player = new Player(0, 0);
        List<Enemy> enemies = GameLoader.loadEnemies("enemies.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display score and prompt for move
            
            String move = scanner.nextLine();

            switch (move) {
                case "w": 
                case "s": 
                case "a": 
                case "d": 
                case "q": return;
                default: 
            }

            // Move enemies and check for collisions
        }
        scanner.close();
    }
}