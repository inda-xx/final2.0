public class Player {
    private int x;
    private int y;
    private int score;
    private int health;

    // Constructor
    public Player(int x, int y) {
        // Initialize player properties
    }

    // Handles player movement in various directions within given grid dimensions
    public void move(String direction, int rows, int cols) {
        // Implement movement logic
    }

    // Updates the score of the player
    public void updateScore(int points) {
        // Modify the player's score
    }

    // Returns the player's current score
    public int getScore() {
        return 0; // Placeholder return
    }

    // Reduces the health of the player by a given amount
    public void reduceHealth(int amount) {
        // Modify the player's health
    }

    // Returns the player's current health
    public int getHealth() {
        return 0; // Placeholder return
    }

    // Checks if the player is still alive
    public boolean isAlive() {
        return false; // Placeholder return
    }

    // Returns the player's current x-coordinate
    public int getX() {
        return 0; // Placeholder return
    }

    // Returns the player's current y-coordinate
    public int getY() {
        return 0; // Placeholder return
    }
}