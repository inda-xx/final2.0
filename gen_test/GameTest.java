package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testInitializeGameSetsCorrectInitialState() {
        Game game = new Game();
        game.initializeGame();
        
        assertEquals(2, game.getEnemies().size());
        assertEquals(2, game.getItems().size());
        assertEquals(1, game.getPlayer().getX());
        assertEquals(1, game.getPlayer().getY());
    }

    @Test
    public void testIsGameOverWhenPlayerCollidesWithEnemy() {
        Game game = new Game();
        game.initializeGame();

        // Simulate player moving to an enemy's position
        game.getPlayer().setX(3);
        game.getPlayer().setY(4);

        assertTrue(game.isGameOver());
    }

    @Test
    public void testIsGameOverWhenPlayerDoesNotCollideWithEnemy() {
        Game game = new Game();
        game.initializeGame();

        assertFalse(game.isGameOver());
    }

    @Test
    public void testIsGameWonWhenAllItemsCollected() {
        Game game = new Game();
        game.initializeGame();

        game.getItems().clear(); // Simulate all items collected

        assertTrue(game.isGameWon());
    }

    @Test
    public void testIsGameWonWhenItemsRemain() {
        Game game = new Game();
        game.initializeGame();

        assertFalse(game.isGameWon());
    }

    @Test
    public void testItemCollectionIncreasesScoreAndRemovesItem() {
        Game game = new Game();
        game.initializeGame();

        int initialScore = game.getPlayer().getScore();
        int initialItemCount = game.getItems().size();

        // Simulate player moving to an item's position
        game.getPlayer().setX(2);
        game.getPlayer().setY(5);
        game.checkItemCollection();

        assertEquals(initialScore + 1, game.getPlayer().getScore());
        assertEquals(initialItemCount - 1, game.getItems().size());
    }

    @Test
    public void testItemCollectionDoesNothingWhenOnEmptyCell() {
        Game game = new Game();
        game.initializeGame();

        int initialScore = game.getPlayer().getScore();
        int initialItemCount = game.getItems().size();

        // Simulate player moving to a cell without an item
        game.getPlayer().setX(0);
        game.getPlayer().setY(0);
        game.checkItemCollection();

        assertEquals(initialScore, game.getPlayer().getScore());
        assertEquals(initialItemCount, game.getItems().size());
    }

    @Test
    public void testMoveEnemiesMovesThemRandomly() {
        Game game = new Game();
        game.initializeGame();

        ArrayList<Enemy> initialPositions = new ArrayList<>();
        for (Enemy enemy : game.getEnemies()) {
            initialPositions.add(new Enemy(enemy.getX(), enemy.getY()));
        }

        game.moveEnemies();

        boolean positionsChanged = false;
        for (int i = 0; i < game.getEnemies().size(); i++) {
            if (game.getEnemies().get(i).getX() != initialPositions.get(i).getX() ||
                game.getEnemies().get(i).getY() != initialPositions.get(i).getY()) {
                positionsChanged = true;
                break;
            }
        }

        assertTrue(positionsChanged);
    }

    @Test
    public void testPlayerMoveChangesCorrectly() {
        Game game = new Game();
        game.initializeGame();

        game.getPlayer().move("UP");
        assertEquals(0, game.getPlayer().getX());
        assertEquals(1, game.getPlayer().getY());

        game.getPlayer().move("DOWN");
        assertEquals(1, game.getPlayer().getX());
        assertEquals(1, game.getPlayer().getY());

        game.getPlayer().move("LEFT");
        assertEquals(1, game.getPlayer().getX());
        assertEquals(0, game.getPlayer().getY());

        game.getPlayer().move("RIGHT");
        assertEquals(1, game.getPlayer().getX());
        assertEquals(1, game.getPlayer().getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayerMoveThrowsExceptionOnInvalidDirection() {
        Game game = new Game();
        game.initializeGame();

        game.getPlayer().move("INVALID_DIRECTION");
    }

    @Test
    public void testPlayerCannotMoveOutOfBounds() {
        Game game = new Game();
        game.initializeGame();

        game.getPlayer().setX(0);
        game.getPlayer().setY(0);
        game.getPlayer().move("UP");

        assertEquals(0, game.getPlayer().getX());
        assertEquals(0, game.getPlayer().getY());

        game.getPlayer().move("LEFT");

        assertEquals(0, game.getPlayer().getX());
        assertEquals(0, game.getPlayer().getY());
    }

    @Test
    public void testUpdateGridReflectsCorrectGameState() {
        Game game = new Game();
        game.initializeGame();

        // Move player to new position
        game.getPlayer().setX(4);
        game.getPlayer().setY(4);

        game.updateGrid();

        char[][] grid = game.getGrid();

        assertEquals('P', grid[4][4]); // Player's new position
        assertEquals('.', grid[1][1]); // Player's previous position
    }
}