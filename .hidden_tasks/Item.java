public class Item {
    private int x;
    private int y;
    private int scoreValue;

    public Item(int x, int y, int scoreValue) {
        this.x = x;
        this.y = y;
        this.scoreValue = scoreValue;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}