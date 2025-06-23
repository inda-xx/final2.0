public class Player extends GameObject {
    private int health;
    private int score;

    public Player(int x, int y) {
        super(x, y);
        // Initialize player state
    }

    public void move(char direction, int mapWidth, int mapHeight) {
        // Implement movement logic based on direction and map boundaries
    }

    public void collect(Item item) {
        // Update score based on item value
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public int getScore() {
        return score;
    }
}