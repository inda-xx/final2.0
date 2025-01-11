GameMap.java
import java.util.List;
import java.util.ArrayList;

public class GameMap {
    private int rows;
    private int cols;
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void loadFromFile(String fileName) throws IOException {
        // Method to load map configuration from a file
    }

    public void movePlayer(String direction) {
        // Method to move the player in the specified direction
    }

    private void checkForItemCollection() {
        // Checks if the player collects any item
    }

    private void checkForEnemyCollision() {
        // Checks if the player collides with any enemy
    }

    public void moveEnemies() {
        // Moves all the enemies randomly
    }

    public boolean allItemsCollected() {
        // Checks if all items are collected
        return false;
    }

    public Player getPlayer() {
        // Returns the player object
        return null;
    }

    public void renderMap() {
        // Renders the game map
    }
}


Player.java
public class Player {
    private int x;
    private int y;
    private int score;
    private int health;

    public Player(int x, int y) {
        // Constructor for initializing the Player
    }

    public void move(String direction, int maxRows, int maxCols) {
        // Move the player in the specified direction within bounds
    }

    public void updateScore(int value) {
        // Updates the player's score
    }

    public void reduceHealth(int value) {
        // Reduces the player's health by a specified value
    }

    public boolean isAlive() {
        // Checks if the player's health is above zero
        return false;
    }

    public int getX() {
        // Returns the x-coordinate of the player
        return 0;
    }

    public int getY() {
        // Returns the y-coordinate of the player
        return 0;
    }

    public int getScore() {
        // Returns the current score of the player
        return 0;
    }

    public int getHealth() {
        // Returns the current health of the player
        return 0;
    }
}


Enemy.java
import java.util.Random;

public class Enemy {
    private int x;
    private int y;

    public Enemy(int x, int y) {
        // Constructor for initializing the Enemy
    }

    public void moveRandomly(int maxRows, int maxCols) {
        // Moves the enemy randomly within bounds
    }

    public int getX() {
        // Returns the x-coordinate of the enemy
        return 0;
    }

    public int getY() {
        // Returns the y-coordinate of the enemy
        return 0;
    }
}


Item.java
public class Item {
    private int x;
    private int y;
    private int scoreValue;

    public Item(int x, int y, int scoreValue) {
        // Constructor for initializing the Item
    }

    public int getX() {
        // Returns the x-coordinate of the item
        return 0;
    }

    public int getY() {
        // Returns the y-coordinate of the item
        return 0;
    }

    public int getScoreValue() {
        // Returns the score value associated with the item
        return 0;
    }
}