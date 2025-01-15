public class PowerUp {
    private int positionX;
    private int positionY;
    private String type;

    public PowerUp(int positionX, int positionY, String type) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.type = type;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PowerUp (" + type + ") at (" + positionX + ", " + positionY + ")";
    }
}