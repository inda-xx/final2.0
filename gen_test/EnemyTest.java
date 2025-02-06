package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyTest {

    @Test
    public void testEnemyInitialization() {
        Enemy enemy = new Enemy(5, 5);
        assertEquals(5, enemy.getX());
        assertEquals(5, enemy.getY());
    }

    @Test
    public void testEnemyMovementWithinBounds() {
        Enemy enemy = new Enemy(3, 3);
        enemy.move(1, 1, 10);
        assertEquals(4, enemy.getX());
        assertEquals(4, enemy.getY());
    }

    @Test
    public void testEnemyMovementOutOfBounds() {
        Enemy enemy = new Enemy(0, 0);
        enemy.move(-1, 0, 10);
        assertEquals(0, enemy.getX());  // Should not move

        enemy.move(0, -1, 10);
        assertEquals(0, enemy.getY());  // Should not move
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

