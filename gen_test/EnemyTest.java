package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyTest {

    @Test
    public void enemyInitialPositionIsSetCorrectly() {
        Enemy enemy = new Enemy(5, 5);
        assertEquals(5, enemy.getX());
        assertEquals(5, enemy.getY());
    }

    @Test
    public void enemyMovesCorrectlyWithinBounds() {
        Enemy enemy = new Enemy(5, 5);
        enemy.move(1, 1, 10);
        assertEquals(6, enemy.getX());
        assertEquals(6, enemy.getY());
    }

    @Test
    public void enemyDoesNotMoveOutsideGridBounds() {
        Enemy enemy = new Enemy(0, 0);
        enemy.move(-1, 0, 10);
        assertEquals(0, enemy.getX());
        assertEquals(0, enemy.getY());

        enemy.move(0, -1, 10);
        assertEquals(0, enemy.getX());
        assertEquals(0, enemy.getY());
    }

    @Test
    public void enemyMovesToBoundaryCorrectly() {
        Enemy enemy = new Enemy(8, 8);
        enemy.move(2, 2, 10);
        assertEquals(9, enemy.getX());
        assertEquals(9, enemy.getY());
    }
}

