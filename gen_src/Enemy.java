// Enemy.java
import java.util.Random;

public class Enemy {
    // Instance variables
    private String name;
    private int position;
    private int speed;
    private String type;

    // Constructor
    public Enemy(String name, int position, int speed, String type) {
        // Initialize instance variables
    }

    // Method to move the enemy
    public void move() {
        // Logic for updating the position
    }

    // Handles collision with a player
    public void handleCollision(Player player) {
        // Logic for handling collision based on type
    }

    // Getter method for position
    public int getPosition() {
        // Return position
        return 0;
    }

    // Getter method for type
    public String getType() {
        // Return type
        return null;
    }

    // Override for toString method
    @Override
    public String toString() {
        // Return string representation of the enemy
        return null;
    }
}

// Player.java should exist in the same project since it is referenced here, 
// but no actual implementation of Player is provided in this context.