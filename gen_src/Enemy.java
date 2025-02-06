public class Enemy {
    private int x, y;

    public Enemy(int startX, int startY) {

        this.x = startX;
        this.y = startY;
    }

    public void move(int dx, int dy, int gridSize) {
        int newX = x + dx;
        int newY = y + dy;
        if (newX >= 0 && newX < gridSize && newY >= 0 && newY < gridSize) {
            x = newX;
            y = newY;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }

}