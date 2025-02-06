package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGameInitialization() {
        Game game = new Game(0, 0);
        assertNotNull(game.getPlayer());
        assertTrue(game.getEnemies().isEmpty());
    }

    @Test
    public void testLoadEnemiesFromFile() throws IOException {
        FileWriter writer = new FileWriter("enemies.txt");
        writer.write("5,5\n10,10\n");
        writer.close();

        Game game = new Game(0, 0);
        game.loadEnemiesFromFile("enemies.txt");
        List<Enemy> enemies = game.getEnemies();

        assertEquals(2, enemies.size());
        assertEquals(5, enemies.get(0).getX());
        assertEquals(5, enemies.get(0).getY());
        assertEquals(10, enemies.get(1).getX());
        assertEquals(10, enemies.get(1).getY());
    }

    @Test
    public void testLoadEnemiesFromInvalidFile() {
        Game game = new Game(0, 0);
        game.loadEnemiesFromFile("nonexistent.txt");
        assertTrue(game.getEnemies().isEmpty());
    }

    @Test
    public void testCollisionDetection() {
        Game game = new Game(5, 5);
        game.getEnemies().add(new Enemy(5, 5));
        game.getEnemies().add(new Enemy(10, 10));

        game.checkForCollisions();
        
        assertEquals(10, game.getPlayer().getScore());
        assertEquals(1, game.getEnemies().size());
    }

    @Test
    public void testCollisionWithMultipleEnemies() {
        Game game = new Game(5, 5);
        game.getEnemies().add(new Enemy(5, 5));
        game.getEnemies().add(new Enemy(5, 5));

        game.checkForCollisions();

        assertEquals(20, game.getPlayer().getScore());
        assertTrue(game.getEnemies().isEmpty());
    }

    @Test
    public void testNoCollision() {
        Game game = new Game(1, 1);
        game.getEnemies().add(new Enemy(2, 2));
        game.getEnemies().add(new Enemy(3, 3));

        game.checkForCollisions();

        assertEquals(0, game.getPlayer().getScore());
        assertEquals(2, game.getEnemies().size());
    }
}