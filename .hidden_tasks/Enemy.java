public class Enemy {
    private String name;
    private int health;
    private int positionX;
    private int positionY;

    public Enemy(String name, int health, int positionX, int positionY) {
        this.name = name;
        this.health = health;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}