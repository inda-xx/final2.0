public class Player {
    private int x;
    private int y;
    private int score;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public void move(String direction, int gridWidth, int gridHeight) {
        switch (direction.toLowerCase()) {
            case "up":
                if (y > 0) y--;
                break;
            case "down":
                if (y < gridHeight - 1) y++;
                break;
            case "left":
                if (x > 0) x--;
                break;
            case "right":
                if (x < gridWidth - 1) x++;
                break;
            default:
                System.out.println("Invalid direction. Please use 'up', 'down', 'left', or 'right'.");
        }
    }

    public void increaseScore(int points) {
        score += points;
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