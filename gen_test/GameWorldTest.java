package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameWorldTest {

    @Test
    public void testGridInitialization() {
        GameWorld world = new GameWorld(5);
        char[][] grid = world.getGridForTesting();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals('-', grid[i][j]);
            }
        }
    }

    @Test
    public void testPlacePlayer() {
        Player player = new Player("John", 2, 2);
        GameWorld world = new GameWorld(5);
        world.placePlayer(player);
        assertEquals('P', world.getGridForTesting()[2][2]);
    }

    @Test
    public void testPlaceEnemy() {
        Enemy enemy = new Enemy("Orc", 3, 3);
        GameWorld world = new GameWorld(5);
        world.placeEnemy(enemy);
        assertEquals('E', world.getGridForTesting()[3][3]);
    }

    @Test
    public void testPlaceCollectibles() {
        GameWorld world = new GameWorld(5);
        world.placeCollectibles(5);
        char[][] grid = world.getGridForTesting();
        int collectibleCount = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (grid[i][j] == 'C') collectibleCount++;
            }
        }
        assertEquals(5, collectibleCount);
    }

    @Test
    public void testUpdatePlayerPosition() {
        Player player = new Player("John", 1, 1);
        GameWorld world = new GameWorld(5);
        world.placePlayer(player);
        player.move("down", 5);
        world.updatePlayerPosition(player, 1, 1);
        char[][] grid = world.getGridForTesting();
        assertEquals('-', grid[1][1]);
        assertEquals('P', grid[2][1]);
    }

    @Test
    public void testDetectCollision() {
        Player player = new Player("John", 1, 1);
        Enemy enemy = new Enemy("Orc", 1, 1);
        GameWorld world = new GameWorld(5);
        assertEquals(true, world.detectCollision(player, enemy));
    }

    @Test
    public void testNoCollision() {
        Player player = new Player("John", 1, 1);
        Enemy enemy = new Enemy("Orc", 2, 2);
        GameWorld world = new GameWorld(5);
        assertEquals(false, world.detectCollision(player, enemy));
    }
}