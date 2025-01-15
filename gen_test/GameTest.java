package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player("Hero", 0, 0);
        assertEquals("Hero", player.getName());
        assertEquals(0, player.getPositionX());
        assertEquals(0, player.getPositionY());
        assertEquals(100, player.getHealth());
        assertEquals(0, player.getScore());
    }

    @Test
    public void testPlayerMoveWithinBounds() {
        Player player = new Player("Hero", 5, 5);
        player.move(1, 0, Game.GRID_SIZE);
        assertEquals(6, player.getPositionX());
        assertEquals(5, player.getPositionY());

        player.move(0, -1, Game.GRID_SIZE);
        assertEquals(6, player.getPositionX());
        assertEquals(4, player.getPositionY());
    }

    @Test
    public void testPlayerMoveOutOfBounds() {
        Player player = new Player("Hero", 0, 0);
        player.move(-1, 0, Game.GRID_SIZE);
        assertEquals(0, player.getPositionX());
        assertEquals(0, player.getPositionY());

        player.move(0, -1, Game.GRID_SIZE);
        assertEquals(0, player.getPositionX());
        assertEquals(0, player.getPositionY());
    }

    @Test
    public void testItemCollection() {
        Player player = new Player("Hero", 5, 5);
        List<Item> items = new ArrayList<>();
        items.add(new Item("Gold Coin", 10, 5, 5));
        items.add(new Item("Health Potion", 20, 3, 4));

        Game.checkItemCollection(player, items);

        assertEquals(10, player.getScore());
        assertEquals(1, items.size());
    }

    @Test
    public void testItemCollectionNoItemNearby() {
        Player player = new Player("Hero", 5, 5);
        List<Item> items = new ArrayList<>();
        items.add(new Item("Gold Coin", 10, 6, 6));
        items.add(new Item("Health Potion", 20, 3, 4));

        Game.checkItemCollection(player, items);

        assertEquals(0, player.getScore());
        assertEquals(2, items.size());
    }

    @Test
    public void testEncounterEnemy() {
        Player player = new Player("Hero", 5, 5);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Orc", 50, 5, 5));
        enemies.add(new Enemy("Goblin", 30, 3, 4));

        Game.checkEnemyInteraction(player, enemies);

        assertEquals(80, player.getHealth());
    }

    @Test
    public void testNoEnemyEncounter() {
        Player player = new Player("Hero", 5, 5);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Orc", 50, 6, 6));
        enemies.add(new Enemy("Goblin", 30, 3, 4));

        Game.checkEnemyInteraction(player, enemies);

        assertEquals(100, player.getHealth());
    }

    @Test
    public void testSpawnItems() {
        List<Item> items = Game.spawnItems(5, Game.GRID_SIZE);
        assertEquals(5, items.size());
    }

    @Test
    public void testItemPositionsNonOverlapping() {
        List<Item> items = Game.spawnItems(5, Game.GRID_SIZE);
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                assertFalse(items.get(i).getPositionX() == items.get(j).getPositionX()
                        && items.get(i).getPositionY() == items.get(j).getPositionY());
            }
        }
    }

    @Test
    public void testEnemyFileLoad() {
        List<Enemy> enemies = Game.loadEnemiesFromFile("enemies.csv");
        assertNotNull(enemies);
    }

    @Test
    public void testEnemyFileLoadErrorHandling() {
        List<Enemy> enemies = Game.loadEnemiesFromFile("nonexistent.csv");
        assertNotNull(enemies);
        assertTrue(enemies.isEmpty());
    }
}