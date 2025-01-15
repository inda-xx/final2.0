public class Enemy {
    private int x;
    private int y;
    private String behavior;

    public Enemy(int x, int y, String behavior) {
        this.x = x;
        this.y = y;
        this.behavior = behavior;
    }

    public void move(Player player, int gridWidth, int gridHeight) {
        if ("random".equalsIgnoreCase(behavior)) {
            int randomDirection = (int) (Math.random() * 4);
            switch (randomDirection) {
                case 0: // Move up
                    if (y > 0) y--;
                    break;
                case 1: // Move down
                    if (y < gridHeight - 1) y++;
                    break;
                case 2: // Move left
                    if (x > 0) x--;
                    break;
                case 3: // Move right
                    if (x < gridWidth - 1) x++;
                    break;
            }
        }
        if ("chasing".equalsIgnoreCase(behavior)) {
            if (x < player.getX()) x++;
            else if (x > player.getX()) x--;
            if (y < player.getY()) y++;
            else if (y > player.getY()) y--;
        }
    }

    public Point getPosition() {
        return new Point(x, y);
    }
}