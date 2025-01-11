import java.util.Random;

public class Enemy {
    private int x;
    private int y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRandomly(int rows, int cols) {
        int direction = (int) (Math.random() * 4); // 0: up, 1: down, 2: left, 3: right
        switch (direction) {
            case 0: // up
                if (x > 0) x--;
                break;
            case 1: // down
                if (x < rows - 1) x++;
                break;
            case 2: // left
                if (y > 0) y--;
                break;
            case 3: // right
                if (y < cols - 1) y++;
                break;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}