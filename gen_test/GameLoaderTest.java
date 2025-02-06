package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLoaderTest {

    @Test
    public void loadEnemiesHandlesInvalidFileGracefully() {
        List<Enemy> enemies = GameLoader.loadEnemies("invalid_file.txt");
        assertNotNull(enemies);
        assertTrue(enemies.isEmpty());
    }

    @Test
    public void loadEnemiesReadsEnemiesFromFileCorrectly() {
        // Assuming "test_enemies.txt" is prepared for testing with known values, e.g., "2,3\n4,5"
        List<Enemy> enemies = GameLoader.loadEnemies("test_enemies.txt");
        assertNotNull(enemies);
        assertEquals(2, enemies.size());
        assertEquals(2, enemies.get(0).getX());
        assertEquals(3, enemies.get(0).getY());
        assertEquals(4, enemies.get(1).getX());
        assertEquals(5, enemies.get(1).getY());
    }
}