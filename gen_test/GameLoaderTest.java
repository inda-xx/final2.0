package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLoaderTest {

    @Test
    public void testLoadEnemies() throws IOException {
        File tempFile = File.createTempFile("enemies", ".txt");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("2,3\n");
        writer.write("5,6\n");
        writer.close();

        List<Enemy> enemies = GameLoader.loadEnemies(tempFile.getAbsolutePath());
        assertEquals(2, enemies.size());
        assertEquals(2, enemies.get(0).getX());
        assertEquals(3, enemies.get(0).getY());

        tempFile.delete();
    }
}