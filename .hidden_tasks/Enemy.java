import java.util.Random;

public class Enemy {
    private String type;
    private int x;
    private int y;

    public Enemy(String type, int startX, int startY) {
        this.type = type;
        this.x = startX;
        this.y = startY;
    }

    public String getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int gridSize) {
        Random random = new Random();
        int direction = random.nextInt(4);
        switch (direction) {
            case 0: // Move up
                if (x > 0) x--;
                break;
            case 1: // Move down
                if (x < gridSize - 1) x++;
                break;
            case 2: // Move left
                if (y > 0) y--;
                break;
            case 3: // Move right
                if (y < gridSize - 1) y++;
                break;
        }
    }
}