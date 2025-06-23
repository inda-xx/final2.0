import java.util.List;
import java.util.ArrayList;

public class GameLoader {
    public static List<GameObject> loadGame(String filename) {
        List<GameObject> objects = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.trim().split(",");
                if (parts.length == 0) {
                    line = reader.readLine();
                    continue;
                }
                switch (parts[0]) {
                    case "P":
                        objects.add(new Player(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                        break;
                    case "E":
                        objects.add(new Enemy(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                        break;
                    case "I":
                        objects.add(new Item(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                        break;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to load game: " + e.getMessage());
        }
        return objects;
    }
}