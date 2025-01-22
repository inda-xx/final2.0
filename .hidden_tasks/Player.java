public class Player {
    private String name;
    private int score;
    private int x;
    private int y;

    public Player(String name, int startX, int startY) {
        this.name = name;
        this.score = 0;
        this.x = startX;
        this.y = startY;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int points) {
        this.score += points;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(String direction, int gridSize) {
        switch (direction.toLowerCase()) {
            case "up":
                if (x > 0) x--;
                break;
            case "down":
                if (x < gridSize - 1) x++;
                break;
            case "left":
                if (y > 0) y--;
                break;
            case "right":
                if (y < gridSize - 1) y++;
                break;
            default:
                System.out.println("Invalid direction!");
                break;
        }
    }
}