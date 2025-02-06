package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void playerInitialPositionIsSetCorrectly() {
        Player player = new Player(0, 0);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        assertEquals(0, player.getScore());
    }

    @Test
    public void playerMovesCorrectlyWithinBounds() {
        Player player = new Player(5, 5);
        player.move(1, 1, 10);
        assertEquals(6, player.getX());
        assertEquals(6, player.getY());
    }

    @Test
    public void playerScoreIncreasesWhenMoving() {
        Player player = new Player(5, 5);
        player.move(1, 0, 10);
        assertEquals(1, player.getScore());
    }

    @Test
    public void playerDoesNotMoveOutsideGridBounds() {
        Player player = new Player(0, 0);
        player.move(-1, 0, 10);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());

        player.move(0, -1, 10);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }
}

