import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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
        gameState = GameState.START;
        player = new Player(0, 0, 100);

        // Predefined enemies
        enemies.add(new Enemy("Goblin", 1, 0, 5));
        enemies.add(new Enemy("Orc", 2, 1, 10));
        enemies.add(new Enemy("Dragon", 3, 2, 25));
    }

    private static void runGameLoop() {
        gameState = GameState.START;
        boolean running = true;

        while (running) {
            switch (gameState) {
                case START:
                    System.out.println("Welcome to the Adventure!");
                    System.out.println("Type 'start' to begin, or 'exit' to quit.");
                    String command = scanner.nextLine();
                    if (command.equalsIgnoreCase("start")) {
                        gameState = GameState.PLAYING;
                    } else if (command.equalsIgnoreCase("exit")) {
                        running = false;
                    }
                    break;

                case PLAYING:
                    while (gameState == GameState.PLAYING) {
                        System.out.println("Enter move (up/down/left/right) or 'exit':");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            running = false;
                            break;
                        }
                        player.move(input);
                        System.out.println("You moved to: (" + player.getX() + ", " + player.getY() + ")");
                        checkCollisions();
                        printStatus();

                        if (!player.isAlive()) {
                            gameState = GameState.GAME_OVER;
                            break;
                        }

                        if (enemies.isEmpty()) {
                            gameState = GameState.WIN;
                            break;
                        }
                    }
                    break;

                case GAME_OVER:
                    System.out.println("You have been defeated. Game Over.");
                    handleEndState();
                    break;

                case WIN:
                    System.out.println("Congratulations, you defeated all enemies!");
                    handleEndState();
                    break;
            }
        }

        System.out.println("Thanks for playing.");
    }

    private static void handleEndState() {
        System.out.println("Type 'restart' to play again, or 'exit' to quit.");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("restart")) {
            loadGame();
            gameState = GameState.PLAYING;
        } else {
            System.exit(0);
        }
    }

    private static void checkCollisions() {
        Iterator<Enemy> iter = enemies.iterator();
        while (iter.hasNext()) {
            Enemy enemy = iter.next();
            if (enemy.getX() == player.getX() && enemy.getY() == player.getY()) {
                System.out.println("You encountered a " + enemy.getType() + "!");
                player.takeDamage(enemy.getDamage());
                player.increaseScore(10);
                iter.remove();
            }
        }
    }

    private static void printStatus() {
        System.out.println("Health: " + player.getHealth() + ", Score: " + player.getScore());
        System.out.println("Enemies Remaining: " + enemies.size());
    }
}