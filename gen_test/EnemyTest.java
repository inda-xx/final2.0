package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyTest {

    @Test
    public void testRandomMoveStaysWithinBoundaries() {
        Enemy enemy = new Enemy(0, 0, "random");
        enemy.move(new Player(5, 5), 5, 5);

        assertTrue(enemy.getPosition().x >= 0 && enemy.getPosition().x < 5);
        assertTrue(enemy.getPosition().y >= 0 && enemy.getPosition().y < 5);
    }

    @Test
    public void testChasingMoveMovesTowardPlayer() {
        Enemy enemy = new Enemy(0, 0, "chasing");
        Player player = new Player(2, 3);

        enemy.move(player, 5, 5);
        assertTrue(enemy.getPosition().x > 0 || enemy.getPosition().y > 0);
    }
}

