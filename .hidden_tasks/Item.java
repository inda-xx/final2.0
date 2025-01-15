public class Item {
    private String name;
    private int points;
    private int positionX;
    private int positionY;

    public Item(String name, int points, int positionX, int positionY) {
        this.name = name;
        this.points = points;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}