package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void testCheckCollision() {
        Player player = new Player(2, 2);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(2, 2));
        enemies.add(new Enemy(4, 4));

        assertTrue(GameLogic.checkCollision(player, enemies));

        player.move(1, 1, 10);
        assertFalse(GameLogic.checkCollision(player, enemies));
    }
}

