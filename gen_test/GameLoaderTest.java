package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLoaderTest {
    @Test
    public void testLoadEmptyFileReturnsEmptyList() throws IOException {
        File tempFile = File.createTempFile("empty", ".txt");
        tempFile.deleteOnExit();
        List<GameObject> out = GameLoader.loadGame(tempFile.getAbsolutePath());
        assertTrue(out.isEmpty());
    }

    @Test
    public void testLoadValidGameObjects() throws IOException {
        File tempFile = File.createTempFile("level", ".txt");
        tempFile.deleteOnExit();
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("P,1,2");
            writer.println("E,3,4");
            writer.println("I,2,2,10");
        }

        List<GameObject> list = GameLoader.loadGame(tempFile.getAbsolutePath());
        assertEquals(3, list.size());

        assertTrue(list.get(0) instanceof Player);
        assertEquals(1, list.get(0).getX());
        assertEquals(2, list.get(0).getY());

        assertTrue(list.get(1) instanceof Enemy);
        assertEquals(3, list.get(1).getX());
        assertEquals(4, list.get(1).getY());

        assertTrue(list.get(2) instanceof Item);
        Item item = (Item) list.get(2);
        assertEquals(2, item.getX());
        assertEquals(2, item.getY());
        assertEquals(10, item.getValue());
    }

    @Test
    public void testLoadHandlesInvalidFormatLinesGracefully() throws IOException {
        File tempFile = File.createTempFile("badlines", ".txt");
        tempFile.deleteOnExit();
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("INVALID");
            writer.println("P,1");
            writer.println("E,2,"); 
            writer.println("P,1,1");
        }

        List<GameObject> list = GameLoader.loadGame(tempFile.getAbsolutePath());
        assertEquals(1, list.size());
        assertTrue(list.get(0) instanceof Player);
    }

    @Test
    public void testLoadNonExistentFileReturnsEmptyList() {
        List<GameObject> list = GameLoader.loadGame("non_existent_file.txt");
        assertTrue(list.isEmpty());
    }
}

// File: GameEngineTest.java
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

