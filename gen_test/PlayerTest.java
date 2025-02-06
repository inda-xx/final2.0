package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player(2, 3);
        assertEquals(2, player.getX());
        assertEquals(3, player.getY());
        assertEquals(0, player.getScore());
    }

    @Test
    public void testPlayerMovementWithinBounds() {
        Player player = new Player(4, 4);
        player.move(1, 0, 10);
        assertEquals(5, player.getX());
        assertEquals(4, player.getY());
        assertEquals(1, player.getScore());
    }

    @Test
    public void testPlayerHitBounds() {
        Player player = new Player(0, 0);
        player.move(-1, 0, 10);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        assertEquals(0, player.getScore());
    }
}

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;

