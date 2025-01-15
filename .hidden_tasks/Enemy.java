public class Enemy {
    private int positionX;
    private int positionY;
    private int speed;

    public Enemy(int positionX, int positionY, int speed) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
    }

    public void move() {
        positionX += speed;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public String toString() {
        return "Enemy at (" + positionX + ", " + positionY + "), Speed: " + speed;
    }
}