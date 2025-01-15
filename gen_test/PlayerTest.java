package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testMoveWithinBoundsMovesPlayerCorrectly() {
        Player player = new Player(2, 2);

        player.move("up", 5, 5);
        assertEquals(2, player.getX());
        assertEquals(1, player.getY());

        player.move("down", 5, 5);
        assertEquals(2, player.getX());
        assertEquals(2, player.getY());

        player.move("left", 5, 5);
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());

        player.move("right", 5, 5);
        assertEquals(2, player.getX());
        assertEquals(2, player.getY());
    }

    @Test
    public void testMoveIgnoresInvalidDirections() {
        Player player = new Player(2, 2);
        player.move("invalid", 5, 5);
        assertEquals(2, player.getX());
        assertEquals(2, player.getY());
    }

    @Test
    public void testMoveDoesNotCrossBoundaries() {
        Player player = new Player(0, 0);
        player.move("up", 5, 5);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());

        player.move("left", 5, 5);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

    @Test
    public void testIncreaseScoreIncrementsScoreCorrectly() {
        Player player = new Player(2, 2);
        player.increaseScore(10);
        assertEquals(10, player.getScore());
    }

    @Test
    public void testIncreaseScoreCumulatesScore() {
        Player player = new Player(2, 2);
        player.increaseScore(10);
        player.increaseScore(5);
        assertEquals(15, player.getScore());
    }
}

