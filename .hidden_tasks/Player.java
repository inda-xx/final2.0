public class Player {
    private int x, y;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void moveUp() { 
        y--; 
    }

    public void moveDown() { 
        y++; 
    }

    public void moveLeft() { 
        x--; 
    }

    public void moveRight() { 
        x++; 
    }

    public void increaseScore(int points) {
        this.score += points;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getScore() { return score; }
}