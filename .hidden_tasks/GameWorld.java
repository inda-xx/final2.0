import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GameWorld {
    private int width;
    private int height;
    private List<Point> points = new ArrayList<>();
    private Point bonusPoint;

    public GameWorld(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void loadGameWorld(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("GRID_SIZE:")) {
                String[] size = line.split(":")[1].trim().split("x");
                width = Integer.parseInt(size[0]);
                height = Integer.parseInt(size[1]);
            } else if (line.startsWith("POINT:")) {
                String[] coordinates = line.split(":")[1].trim().split(",");
                points.add(new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
            }
        }
        reader.close();
    }

    public void generateBonusPoint() {
        Random random = new Random();
        int bonusX = random.nextInt(width);
        int bonusY = random.nextInt(height);
        bonusPoint = new Point(bonusX, bonusY);
    }

    public boolean checkPointCollected(Player player) {
        Point playerPosition = new Point(player.getX(), player.getY());
        if (points.contains(playerPosition)) {
            points.remove(playerPosition);
            return true;
        }
        return false;
    }

    public boolean checkBonusPointCollected(Player player) {
        Point playerPosition = new Point(player.getX(), player.getY());
        if (bonusPoint != null && bonusPoint.equals(playerPosition)) {
            bonusPoint = null;
            return true;
        }
        return false;
    }

    public boolean checkCollision(Player player, List<Enemy> enemies) {
        Point playerPosition = new Point(player.getX(), player.getY());
        for (Enemy enemy : enemies) {
            if (enemy.getPosition().equals(playerPosition)) {
                return true;
            }
        }
        return false;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}