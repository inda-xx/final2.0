import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(0);
        List<Enemy> enemies = EnemyLoader.readEnemiesFromFile("enemies.txt");
        List<PowerUp> powerUps = Arrays.asList(
            new PowerUp(5, "scoreBoost"),
            new PowerUp(15, "shield"),
            new PowerUp(25, "scoreBoost")
        );
        Game game = new Game(player, enemies, powerUps);
        game.start();
    }
}