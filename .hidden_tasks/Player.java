public class Player {
    private int positionX;
    private int positionY;
    private int score;

    public Player(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.score = 0;
    }

    public void move(int deltaX, int deltaY) {
        positionX += deltaX;
        positionY += deltaY;
    }

    public void increaseScore(int points) {
        score += points;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player at (" + positionX + ", " + positionY + "), Score: " + score;
    }
}