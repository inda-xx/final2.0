package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyTest {

    @Test
    public void testEnemyInitialization() {
        Enemy enemy = new Enemy("Orc", 2, 3);
        assertEquals("Orc", enemy.getType());
        assertEquals(2, enemy.getX());
        assertEquals(3, enemy.getY());
    }

    @Test
    public void testEnemyMovementWithinBounds() {
        Enemy enemy = new Enemy("Orc", 2, 2);
        enemy.move(5); // Grid size is 5x5
        assertTrue(enemy.getX() >= 0 && enemy.getX() < 5);
        assertTrue(enemy.getY() >= 0 && enemy.getY() < 5);
    }

    @Test
    public void testEnemyDoesNotMoveOutOfBounds() {
        Enemy enemy = new Enemy("Troll", 0, 0);
        for (int i = 0; i < 100; i++) {
            enemy.move(5);
            assertTrue(enemy.getX() >= 0 && enemy.getX() < 5);
            assertTrue(enemy.getY() >= 0 && enemy.getY() < 5);
        }
    }
}

// PlayerTest.java
import org.junit.Test;

import static org.junit.Assert.assertEquals;

