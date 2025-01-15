import java.util.Random;

public class Enemy {
    private String name;
    private int position;
    private int speed;
    private String type;

    public Enemy(String name, int position, int speed, String type) {
        this.name = name;
        this.position = position;
        this.speed = speed;
        this.type = type;
    }

    public void move() {
        position -= speed;
        if (position < 0) {
            position = 0;
        }
    }

    public void handleCollision(Player player) {
        if (type.equals("speedy")) {
            player.decrementScore(10);
            Random random = new Random();
            position = random.nextInt(50);
        } else if (type.equals("strong")) {
            player.decrementScore(20);
        }
    }

    public int getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Enemy{name='" + name + "', position=" + position + ", speed=" + speed + ", type='" + type + "'}";
    }
}