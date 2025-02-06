package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerMovement() {
        Player player = new Player(2, 2);
        player.move(1, 1, 10);
        assertEquals(3, player.getX());
        assertEquals(3, player.getY());
        assertEquals(1, player.getScore());
    }

    @Test
    public void testPlayerOutOfBoundsMovement() {
        Player player = new Player(0, 0);
        player.move(-1, 0, 10);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        assertEquals(0, player.getScore());
    }
}

