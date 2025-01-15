public class PowerUp {
    private int position;
    private String type;

    public PowerUp(int position, String type) {
        this.position = position;
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    public void applyEffect(Player player) {
        if (type.equals("scoreBoost")) {
            player.incrementScore(15);
        } else if (type.equals("shield")) {
            player.activateShield();
        }
    }

    @Override
    public String toString() {
        return "PowerUp{position=" + position + ", type='" + type + "'}";
    }
}