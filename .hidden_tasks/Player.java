public class Player {
    private int x;
    private int y;
    private int score;
    private int health;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
        this.health = 100; // Starting health
    }

    public void move(String direction, int rows, int cols) {
        switch (direction.toLowerCase()) {
            case "up":
                if (x > 0) x--;
                break;
            case "down":
                if (x < rows - 1) x++;
                break;
            case "left":
                if (y > 0) y--;
                break;
            case "right":
                if (y < cols - 1) y++;
                break;
            default:
                System.out.println("Invalid direction!");
        }
    }

    public void updateScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return this.score;
    }

    public void reduceHealth(int amount) {
        this.health -= amount;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}