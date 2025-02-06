package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void checkCollisionDetectsCollision() {
        Player player = new Player(3, 3);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(3, 3));

        assertTrue(GameLogic.checkCollision(player, enemies));
    }

    @Test
    public void checkCollisionReturnsFalseForNoCollision() {
        Player player = new Player(3, 3);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(4, 4));

        assertFalse(GameLogic.checkCollision(player, enemies));
    }

    @Test
    public void moveEnemiesChangesPositions() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(5, 5));
        
        GameLogic.moveEnemies(enemies, 10);
        
        // Check if the enemy moved (its position is different from initial)
        assertNotEquals(5, enemies.get(0).getX());
        assertNotEquals(5, enemies.get(0).getY());
    }
}

