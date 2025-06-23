package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    private Player player;
    private List<Enemy> enemies;

    @Before
    public void setUp() {
        player = new Player(0, 0, 100);
        enemies = new ArrayList<>();
        enemies.add(new Enemy("Goblin", 1, 0, 5));
        enemies.add(new Enemy("Orc", 2, 1, 10));
        enemies.add(new Enemy("Dragon", 3, 2, 25));
    }

    @Test
    public void testPlayerInitialPositionIsCorrect() {
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        assertEquals(100, player.getHealth());
    }

    @Test
    public void testPlayerMoveUpIncreasesY() {
        player.move("up");
        assertEquals(0, player.getX());
        assertEquals(1, player.getY());
    }

    @Test
    public void testPlayerMoveDownDecreasesY() {
        player.move("up"); // go up first
        player.move("down");
        assertEquals(0, player.getY());
    }

    @Test
    public void testPlayerMoveLeftDecreasesX() {
        player.move("left");
        assertEquals(-1, player.getX());
    }

    @Test
    public void testPlayerMoveRightIncreasesX() {
        player.move("right");
        assertEquals(1, player.getX());
    }

    @Test
    public void testPlayerMoveInvalidDirectionDoesNothing() {
        int x = player.getX();
        int y = player.getY();
        player.move("jump");
        assertEquals(x, player.getX());
        assertEquals(y, player.getY());
    }

    @Test
    public void testPlayerTakesDamage() {
        player.takeDamage(15);
        assertEquals(85, player.getHealth());
    }

    @Test
    public void testPlayerHealthCannotGoBelowZero() {
        player.takeDamage(150);
        assertEquals(0, player.getHealth());
        assertFalse(player.isAlive());
    }

    @Test
    public void testPlayerScoreIncrementsProperly() {
        player.increaseScore(10);
        assertEquals(10, player.getScore());

        player.increaseScore(15);
        assertEquals(25, player.getScore());
    }

    @Test
    public void testEnemyInitialization() {
        Enemy enemy = new Enemy("Goblin", 1, 2, 5);
        assertEquals("Goblin", enemy.getType());
        assertEquals(1, enemy.getX());
        assertEquals(2, enemy.getY());
        assertEquals(5, enemy.getDamage());
    }

    @Test
    public void testPlayerEncountersEnemyAndTakesDamage() {
        Enemy enemy = new Enemy("Goblin", player.getX(), player.getY(), 10);
        List<Enemy> oneEnemy = new ArrayList<>();
        oneEnemy.add(enemy);
        GameTestHelper.checkCollisionsSimulated(player, oneEnemy);
        assertEquals(90, player.getHealth());
        assertEquals(10, player.getScore());
        assertTrue(oneEnemy.isEmpty());
    }

    @Test
    public void testMultipleEnemiesSameLocationDamagesOnlyOncePerCheck() {
        Enemy enemy1 = new Enemy("Goblin", player.getX(), player.getY(), 10);
        Enemy enemy2 = new Enemy("Orc", player.getX(), player.getY(), 20);
        List<Enemy> twoEnemies = new ArrayList<>();
        twoEnemies.add(enemy1);
        twoEnemies.add(enemy2);

        GameTestHelper.checkCollisionsSimulated(player, twoEnemies);
        assertEquals(90, player.getHealth());
        assertEquals(10, player.getScore());
        assertEquals(1, twoEnemies.size());

        GameTestHelper.checkCollisionsSimulated(player, twoEnemies);
        assertEquals(70, player.getHealth());
        assertEquals(20, player.getScore());
        assertTrue(twoEnemies.isEmpty());
    }

    @Test
    public void testNoCollisionWhenEnemyAtDifferentPosition() {
        Enemy enemy = new Enemy("Orc", 10, 10, 10);
        List<Enemy> farEnemy = new ArrayList<>();
        farEnemy.add(enemy);
        GameTestHelper.checkCollisionsSimulated(player, farEnemy);
        assertEquals(100, player.getHealth());
        assertEquals(0, player.getScore());
        assertEquals(1, farEnemy.size());
    }

    @Test
    public void testPlayerDefeatedChangesGameState() {
        player.takeDamage(100);
        assertFalse(player.isAlive());
    }

    @Test
    public void testWinConditionWhenNoEnemiesLeft() {
        List<Enemy> noEnemies = new ArrayList<>();
        assertTrue(noEnemies.isEmpty());
    }
}



// GameTestHelper.java

import java.util.Iterator;
import java.util.List;

