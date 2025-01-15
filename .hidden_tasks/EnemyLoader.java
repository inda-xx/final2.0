import java.util.List;
import java.util.ArrayList;

public class EnemyLoader {
    public static List<Enemy> readEnemiesFromFile(String filename) {
        List<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int position = Integer.parseInt(parts[1]);
                int speed = Integer.parseInt(parts[2]);
                String type = parts[3];
                enemies.add(new Enemy(name, position, speed, type));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return enemies;
    }
}