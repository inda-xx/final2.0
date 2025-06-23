public class Player extends GameObject {
    private int health;
    private int score;

    public Player(int x, int y) {
        super(x, y);
        this.health = 3;
        this.score = 0;
    }

    public void move(char direction, int mapWidth, int mapHeight) {
        switch (direction) {
            case 'W':
                if (y > 0) y--;
                break;
            case 'S':
                if (y < mapHeight - 1) y++;
                break;
            case 'A':
                if (x > 0) x--;
                break;
            case 'D':
                if (x < mapWidth - 1) x++;
                break;
        }
    }

    public void collect(Item item) {
        score += item.getValue();
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