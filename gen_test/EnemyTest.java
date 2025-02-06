package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyTest {

    @Test
    public void testEnemyMovementWithinBounds() {
        Enemy enemy = new Enemy(5, 5);
        enemy.move(1, 0, 10);
        assertEquals(6, enemy.getX());
        assertEquals(5, enemy.getY());

        enemy.move(-1, -1, 10);
        assertEquals(5, enemy.getX());
        assertEquals(4, enemy.getY());
    }

    @Test
    public void testEnemyMovementOutOfBounds() {
        Enemy enemy = new Enemy(0, 0);
        enemy.move(-1, 0, 10);
        assertEquals(0, enemy.getX());
        assertEquals(0, enemy.getY());

        enemy.move(0, -1, 10);
        assertEquals(0, enemy.getX());
        assertEquals(0, enemy.getY());
    }
}

