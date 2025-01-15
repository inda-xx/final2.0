package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameSetupTest {

    @Test
    public void testLoadPlayerParsesPlayerCorrectly() throws IOException {
        String fileContent = "START_POSITION:2,3\n";
        File tempFile = writeToTempFile(fileContent);

        Player player = GameSetup.loadPlayer(tempFile.getAbsolutePath(), 10, 10);

        assertEquals(2, player.getX());
        assertEquals(3, player.getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadPlayerThrowsExceptionForInvalidStartPosition() throws IOException {
        String fileContent = "START_POSITION:20,30\n";
        File tempFile = writeToTempFile(fileContent);

        GameSetup.loadPlayer(tempFile.getAbsolutePath(), 10, 10);
    }

    @Test
    public void testLoadEnemiesParsesEnemiesCorrectly() throws IOException {
        String fileContent = "ENEMY:2,3,random\nENEMY:4,5,chasing\n";
        File tempFile = writeToTempFile(fileContent);

        List<Enemy> enemies = GameSetup.loadEnemies(tempFile.getAbsolutePath(), 10, 10);

        assertEquals(2, enemies.size());
        assertEquals(new Point(2, 3), enemies.get(0).getPosition());
        assertEquals(new Point(4, 5), enemies.get(1).getPosition());
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