public class Item extends GameObject {
    private int value;

    public Item(int x, int y, int value) {
        super(x, y);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}