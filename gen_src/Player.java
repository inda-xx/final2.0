public class Player {
    private int x, y;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void move(int dx, int dy, int gridSize) {
        int newX = x + dx;
        int newY = y + dy;
        if (newX >= 0 && newX < gridSize && newY >= 0 && newY < gridSize) {
            x = newX;
            y = newY;
            score++;
        } else {
            System.out.println("Cannot move outside the grid!");
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getScore() { return score; }
}