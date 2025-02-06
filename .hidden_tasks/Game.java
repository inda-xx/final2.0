import java.util.List;
import java.util.ArrayList;

public class Game {
    private List<Enemy> enemies = new ArrayList<>();
    private Player player;

    public Game(int startX, int startY) {
        this.player = new Player(startX, startY);
    }

    public void loadEnemiesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                enemies.add(new Enemy(x, y));
            }
        } catch (IOException e) {
            System.out.println("Error reading enemy file: " + e.getMessage());
        }
    }

    public void checkForCollisions() {
        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {
            Enemy enemy = iterator.next();
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                player.increaseScore(10);
                iterator.remove();
            }
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return player;
    }
}