// Game.java
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Game {
    private static GameState gameState;
    private static Scanner scanner = new Scanner(System.in);
    private static Player player;
    private static List<Enemy> enemies = new ArrayList<>();

    public static void main(String[] args) {
        loadGame();
        runGameLoop();
    }

    private static void loadGame() {
        // Initialize game state and player
        // Add enemies to the list
    }

    private static void runGameLoop() {
        // Main game loop to handle state transitions
    }

    private static void handleEndState() {
        // Handle restart or exit after game ends
    }

    private static void checkCollisions() {
        // Detect and handle collision between player and enemies
    }

    private static void printStatus() {
        // Print player's health, score, and count of remaining enemies
    }
}