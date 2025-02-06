import java.util.List;
import java.util.ArrayList;

public class GameLoader {
    public static List<Enemy> loadEnemies(String filename) {
        List<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                enemies.add(new Enemy(x, y));
            }
        } catch (IOException e) {
            System.out.println("Error loading enemies: " + e.getMessage());
        }
        return enemies;
    }
}