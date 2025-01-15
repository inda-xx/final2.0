package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameWorldTest {

    @Test
    public void testConstructorInitializesCorrectDimensions() {
        GameWorld gameWorld = new GameWorld(10, 20);
        assertEquals(10, gameWorld.getWidth());
        assertEquals(20, gameWorld.getHeight());
    }

    @Test
    public void testLoadGameWorldParsesGridSizeCorrectly() throws IOException {
        String fileContent = "GRID_SIZE:10x15\n";
        File tempFile = writeToTempFile(fileContent);

        GameWorld gameWorld = new GameWorld(0, 0);
        gameWorld.loadGameWorld(tempFile.getAbsolutePath());

        assertEquals(10, gameWorld.getWidth());
        assertEquals(15, gameWorld.getHeight());
    }

    @Test
    public void testLoadGameWorldParsesPointsCorrectly() throws IOException {
        String fileContent = "GRID_SIZE:10x10\nPOINT:1,2\nPOINT:3,4\n";
        File tempFile = writeToTempFile(fileContent);

        GameWorld gameWorld = new GameWorld(0, 0);
        gameWorld.loadGameWorld(tempFile.getAbsolutePath());

        List<Point> expectedPoints = List.of(new Point(1, 2), new Point(3, 4));
        assertEquals(expectedPoints, gameWorld.getPoints());
    }

    @Test
    public void testGenerateBonusPointCreatesPointWithinBounds() {
        GameWorld gameWorld = new GameWorld(5, 5);
        gameWorld.generateBonusPoint();

        Point bonusPoint = null;
        try {
            bonusPoint = (Point) gameWorld.getClass()
                    .getDeclaredField("bonusPoint")
                    .get(gameWorld);
        } catch (Exception e) {
            fail("Reflection error: " + e.getMessage());
        }

        assertNotNull(bonusPoint);
        assertTrue(bonusPoint.x >= 0 && bonusPoint.x < 5);
        assertTrue(bonusPoint.y >= 0 && bonusPoint.y < 5);
    }

    @Test
    public void testCheckPointCollectedRemovesCollectedPoint() {
        GameWorld gameWorld = new GameWorld(5, 5);
        Player player = new Player(2, 3);

        gameWorld.getPoints().add(new Point(2, 3));
        boolean collected = gameWorld.checkPointCollected(player);

        assertTrue(collected);
        assertFalse(gameWorld.getPoints().contains(new Point(2, 3)));
    }

    @Test
    public void testCheckPointCollectedDoesNotRemoveNonexistentPoint() {
        GameWorld gameWorld = new GameWorld(5, 5);
        Player player = new Player(2, 3);

        boolean collected = gameWorld.checkPointCollected(player);

        assertFalse(collected);
    }

    @Test
    public void testCheckBonusPointCollectedRemovesBonusPoint() {
        GameWorld gameWorld = new GameWorld(5, 5);
        Player player = new Player(2, 3);

        try {
            gameWorld.generateBonusPoint();
            Point bonusPoint = (Point) gameWorld.getClass()
                    .getDeclaredField("bonusPoint")
                    .get(gameWorld);
            bonusPoint.x = 2;
            bonusPoint.y = 3;

            boolean collected = gameWorld.checkBonusPointCollected(player);

            assertTrue(collected);
            assertNull(gameWorld.getClass().getDeclaredField("bonusPoint").get(gameWorld));
        } catch (Exception e) {
            fail("Reflection error: " + e.getMessage());
        }
    }

    @Test
    public void testCheckBonusPointCollectedIgnoresNullBonusPoint() {
        GameWorld gameWorld = new GameWorld(5, 5);
        Player player = new Player(2, 3);

        boolean collected = gameWorld.checkBonusPointCollected(player);

        assertFalse(collected);
    }

    @Test
    public void testCheckCollisionIdentifiesCollisionWithEnemy() {
        GameWorld gameWorld = new GameWorld(5, 5);
        Player player = new Player(2, 3);
        List<Enemy> enemies = List.of(new Enemy(2, 3, "random"));

        boolean collision = gameWorld.checkCollision(player, enemies);

        assertTrue(collision);
    }

    @Test
    public void testCheckCollisionIgnoresNoCollision() {
        GameWorld gameWorld = new GameWorld(5, 5);
        Player player = new Player(2, 3);
        List<Enemy> enemies = List.of(new Enemy(1, 3, "random"));

        boolean collision = gameWorld.checkCollision(player, enemies);

        assertFalse(collision);
    }

    private File writeToTempFile(String content) throws IOException {
        File tempFile = File.createTempFile("test", ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(content);
        writer.close();
        tempFile.deleteOnExit();
        return tempFile;
    }
}

