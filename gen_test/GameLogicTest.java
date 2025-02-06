package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void testEnemyAndPlayerCollision() {
        Player player = new Player(2, 2);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(2, 2));
        assertTrue(GameLogic.checkCollision(player, enemies));
    }

    @Test
    public void testNoCollision() {
        Player player = new Player(1, 1);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(3, 3));
        assertFalse(GameLogic.checkCollision(player, enemies));
    }
}