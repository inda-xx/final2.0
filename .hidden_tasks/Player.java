public class Player {
    private int x;
    private int y;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void moveUp() {
        this.x -= 1;
    }

    public void moveDown() {
        this.x += 1;
    }

    public void moveLeft() {
        this.y -= 1;
    }

    public void moveRight() {
        this.y += 1;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return score;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}