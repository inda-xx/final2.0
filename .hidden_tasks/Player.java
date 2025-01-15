public class Player {
    private int position;
    private int score;
    private boolean shieldActive;

    public Player(int startPosition) {
        this.position = startPosition;
        this.score = 0;
        this.shieldActive = false;
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public void activateShield() {
        this.shieldActive = true;
    }

    public void incrementScore(int points) {
        score += points;
    }

    public void decrementScore(int points) {
        if (shieldActive) {
            System.out.println("Shield protected the player from losing points!");
            shieldActive = false;
        } else {
            score -= points;
        }
    }

    public boolean isColliding(int enemyPosition) {
        return this.position == enemyPosition;
    }

    public int getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }
}