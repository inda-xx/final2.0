import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<PowerUp> powerUps;
    private boolean isRunning;
    private static final int GRID_SIZE = 10;

    public Game() {
        this.enemies = new ArrayList<>();
        this.powerUps = new ArrayList<>();
        this.isRunning = true;
    }

    public void initializeGame() {
        this.player = new Player(0, 0);
        Random random = new Random();

        // Generate enemies
        for (int i = 0; i < 3; i++) {
            int posX = random.nextInt(GRID_SIZE);
            int posY = random.nextInt(GRID_SIZE);
            int speed = random.nextInt(3) + 1;
            enemies.add(new Enemy(posX, posY, speed));
        }

        // Generate power-ups
        for (int i = 0; i < 2; i++) {
            int posX = random.nextInt(GRID_SIZE);
            int posY = random.nextInt(GRID_SIZE);
            String type = random.nextBoolean() ? "scoreBoost" : "invincibility";
            powerUps.add(new PowerUp(posX, posY, type));
        }
    }

    public void printGameState() {
        System.out.println(player);
        for (Enemy enemy : enemies) {
            System.out.println(enemy);
        }
        for (PowerUp powerUp : powerUps) {
            System.out.println(powerUp);
        }
    }

    public void updateGame(String input) {
        int deltaX = 0;
        int deltaY = 0;

        switch (input.toUpperCase()) {
            case "W":
                deltaY = -1;
                break;
            case "A":
                deltaX = -1;
                break;
            case "S":
                deltaY = 1;
                break;
            case "D":
                deltaX = 1;
                break;
            default:
                System.out.println("Invalid input! Please use W, A, S, D to move.");
                return;
        }

        player.move(deltaX, deltaY);
        checkCollisions();
        moveEnemies();
        checkPowerUpCollection();

        if (!isRunning) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }

    private void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.move();
        }
    }

    private void checkCollisions() {
        for (Enemy enemy : enemies) {
            if (player.getPositionX() == enemy.getPositionX() &&
                player.getPositionY() == enemy.getPositionY()) {
                System.out.println("Game Over! You collided with an enemy at: (" + enemy.getPositionX() + ", " + enemy.getPositionY() + ")");
                isRunning = false;
                return;
            }
        }
    }

    private void checkPowerUpCollection() {
        PowerUp collected = null;
        for (PowerUp powerUp : powerUps) {
            if (player.getPositionX() == powerUp.getPositionX() &&
                player.getPositionY() == powerUp.getPositionY()) {
                collected = powerUp;
                break;
            }
        }

        if (collected != null) {
            if (collected.getType().equals("scoreBoost")) {
                player.increaseScore(50);
                System.out.println("Collected score boost! Score: " + player.getScore());
            } else if (collected.getType().equals("invincibility")) {
                System.out.println("Collected invincibility! Temporary protection enabled.");
            }
            powerUps.remove(collected);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame();
        game.printGameState();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your move (W/A/S/D): ");
            String input = scanner.nextLine();
            game.updateGame(input);
            game.printGameState();
        }
    }
}