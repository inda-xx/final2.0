import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class GameSetup {
    public static Player loadPlayer(String fileName, int gridWidth, int gridHeight) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        reader.close();

        if (line.startsWith("START_POSITION:")) {
            String[] coordinates = line.split(":")[1].trim().split(",");
            int startX = Integer.parseInt(coordinates[0]);
            int startY = Integer.parseInt(coordinates[1]);

            if (startX < 0 || startX >= gridWidth || startY < 0 || startY >= gridHeight) {
                throw new IllegalArgumentException("Invalid starting position outside grid boundaries.");
            }
            return new Player(startX, startY);
        }
        throw new IOException("Invalid or corrupt player file.");
    }

    public static List<Enemy> loadEnemies(String fileName, int gridWidth, int gridHeight) throws IOException {
        List<Enemy> enemies = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("ENEMY:")) {
                String[] parts = line.split(":")[1].trim().split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                String behavior = "random";
                if (parts.length > 2) {
                    behavior = parts[2];
                }

                if (x >= 0 && x < gridWidth && y >= 0 && y < gridHeight) {
                    enemies.add(new Enemy(x, y, behavior));
                }
            }
        }
        reader.close();
        return enemies;
    }
}