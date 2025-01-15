import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private List<Enemy> enemies;
    private List<PowerUp> powerUps;

    public Game(Player player, List<Enemy> enemies, List<PowerUp> powerUps) {
        this.player = player;
        this.enemies = enemies;
        this.powerUps = powerUps;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        long gameDuration = 60000;
        boolean isRunning = true;

        while (isRunning) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime > gameDuration) {
                System.out.println("Time's up! Final Score: " + player.getScore());
                isRunning = false;
                break;
            }

            System.out.println("Player Position: " + player.getPosition() + ", Score: " + player.getScore());
            for (Enemy enemy : enemies) {
                System.out.println(enemy);
            }
            for (PowerUp powerUp : powerUps) {
                System.out.println(powerUp);
            }

            System.out.print("Move (a: left, d: right, q: quit): ");
            String input = scanner.nextLine();
            if (input.equals("a")) {
                player.moveLeft();
            } else if (input.equals("d")) {
                player.moveRight();
                player.incrementScore(5);
            } else if (input.equals("q")) {
                isRunning = false;
                break;
            }

            checkPowerUpCollision();

            for (Enemy enemy : enemies) {
                enemy.move();
                if (player.isColliding(enemy.getPosition())) {
                    System.out.println("Collision with " + enemy.getType() + "!");
                    enemy.handleCollision(player);
                }
            }

            if (player.getScore() >= 50) {
                System.out.println("Congratulations! You won with a score of " + player.getScore());
                isRunning = false;
                break;
            }

            if (player.getScore() < 0) {
                System.out.println("Game Over! Your score is below 0.");
                isRunning = false;
                break;
            }

            System.out.println("Time Remaining: " + (gameDuration - elapsedTime) / 1000 + " seconds");
        }
        scanner.close();
    }

    private void checkPowerUpCollision() {
        Iterator<PowerUp> iterator = powerUps.iterator();
        while (iterator.hasNext()) {
            PowerUp powerUp = iterator.next();
            if (player.getPosition() == powerUp.getPosition()) {
                System.out.println("Power-Up collected: " + powerUp.getType());
                powerUp.applyEffect(player);
                iterator.remove();
            }
        }
    }
}