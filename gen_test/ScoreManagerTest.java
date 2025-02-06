package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreManagerTest {

    @Test
    public void testHighScoreInitialization() {
        ScoreManager manager = new ScoreManager();
        int initialScore = manager.getHighScore();
        assertTrue(initialScore >= 0);
    }

    @Test
    public void testSaveHighScore() throws IOException {
        ScoreManager manager = new ScoreManager();
        int newHighScore = manager.getHighScore() + 10;
        manager.saveHighScore(newHighScore);
        ScoreManager newManager = new ScoreManager();
        assertEquals(newHighScore, newManager.getHighScore());
    }

    @Test
    public void testSaveLowerScoreDoesNotChangeHighScore() throws IOException {
        ScoreManager manager = new ScoreManager();
        int initialHighScore = manager.getHighScore();
        manager.saveHighScore(initialHighScore - 10);
        ScoreManager newManager = new ScoreManager();
        assertEquals(initialHighScore, newManager.getHighScore());
    }

    @Test
    public void testLoadingEmptyHighScoreFile() throws IOException {
        new FileWriter("highscore.txt").close();
        ScoreManager manager = new ScoreManager();
        assertTrue(manager.getHighScore() >= 0);
    }

    @Test
    public void testInvalidHighScoreFile() throws IOException {
        try (FileWriter writer = new FileWriter("highscore.txt")) {
            writer.write("invalid_score");
        }
        ScoreManager manager = new ScoreManager();
        assertTrue(manager.getHighScore() >= 0);
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

