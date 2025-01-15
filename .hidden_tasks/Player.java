public class Player {
    private String name;
    private int score;
    private int health;
    private int positionX;
    private int positionY;

    public Player(String name, int positionX, int positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.score = 0;
        this.health = 100;
    }

    public void move(int x, int y, int gridSize) {
        int newX = positionX + x;
        int newY = positionY + y;
        if (newX >= 0 && newX < gridSize && newY >= 0 && newY < gridSize) {
            positionX = newX;
            positionY = newY;
        } else {
            System.out.println("Move out of bounds!");
        }
    }

    public void updateScore(int points) {
        this.score += points;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }
}