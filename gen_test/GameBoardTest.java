package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameBoardTest {

    @Test
    public void testInitialGameState() {
        Player player = new Player(0, 0);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(2, 2));
        enemies.add(new Enemy(3, 3));
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, 1));
        items.add(new Item(4, 4));

        GameBoard gameBoard = new GameBoard(5, 5, player, enemies, items);
        assertEquals(5, gameBoard.getWidth());
        assertEquals(5, gameBoard.getHeight());
        assertEquals(player, gameBoard.getPlayer());
        assertEquals(2, gameBoard.getEnemies().size());
        assertEquals(2, gameBoard.getItems().size());
    }

    @Test
    public void testPlayerMovement() {
        Player player = new Player(0, 0);
        List<Enemy> enemies = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        GameBoard gameBoard = new GameBoard(5, 5, player, enemies, items);

        gameBoard.updateGameState("UP");
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());  // Player at the top boundary cannot move further up.

        gameBoard.updateGameState("DOWN");
        assertEquals(0, player.getX());
        assertEquals(1, player.getY());

        gameBoard.updateGameState("RIGHT");
        assertEquals(1, player.getX());
        assertEquals(1, player.getY());

        gameBoard.updateGameState("LEFT");
        assertEquals(0, player.getX());
        assertEquals(1, player.getY());
    }

    @Test
    public void testCollectItems() {
        Player player = new Player(0, 0);
        List<Enemy> enemies = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, 1));
        GameBoard gameBoard = new GameBoard(5, 5, player, enemies, items);

        assertEquals(1, gameBoard.getItems().size());

        gameBoard.updateGameState("DOWN");
        gameBoard.updateGameState("RIGHT");

        assertTrue(gameBoard.getItems().isEmpty());  // Player has collected the item.
    }

    @Test
    public void testEnemyMovement() {
        Player player = new Player(0, 0);
        List<Enemy> enemies = new ArrayList<>();
        Enemy enemy = new Enemy(2, 2);
        enemies.add(enemy);
        List<Item> items = new ArrayList<>();
        GameBoard gameBoard = new GameBoard(5, 5, player, enemies, items);

        int initialDistance = Math.abs(enemy.getX() - player.getX()) + Math.abs(enemy.getY() - player.getY());

        gameBoard.updateEnemyPositions();

        int newDistance = Math.abs(enemy.getX() - player.getX()) + Math.abs(enemy.getY() - player.getY());

        assertTrue(newDistance <= initialDistance);  // Enemy should move towards the player or stay still.
    }

    @Test
    public void testGameOverConditions() {
        Player player = new Player(0, 0);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(0, 1));  // Enemy starts adjacent to the player.
        List<Item> items = new ArrayList<>();
        GameBoard gameBoard = new GameBoard(5, 5, player, enemies, items);

        assertTrue(!gameBoard.isGameOver());

        gameBoard.updateEnemyPositions();

        assertTrue(gameBoard.isGameOver());  // Game should end because the enemy moved to the player's position.
    }

    @Test
    public void testBoundaryConditions() {
        Player player = new Player(0, 0);
        List<Enemy> enemies = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        GameBoard gameBoard = new GameBoard(5, 5, player, enemies, items);

        gameBoard.updateGameState("LEFT");
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());  // Player cannot move left out of bounds.

        gameBoard.updateGameState("UP");
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());  // Player cannot move up out of bounds.

        player.setX(4);
        player.setY(4);

        gameBoard.updateGameState("RIGHT");
        assertEquals(4, player.getX());
        assertEquals(4, player.getY());  // Player cannot move right out of bounds.

        gameBoard.updateGameState("DOWN");
        assertEquals(4, player.getX());
        assertEquals(4, player.getY());  // Player cannot move down out of bounds.
    }

    @Test
    public void testInvalidInput() {
        Player player = new Player(0, 0);
        List<Enemy> enemies = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        GameBoard gameBoard = new GameBoard(5, 5, player, enemies, items);

        gameBoard.updateGameState("INVALID");
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());  // Player's position should remain unchanged.
    }
}