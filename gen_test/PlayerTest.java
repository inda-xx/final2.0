package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player("John", 1, 2);
        assertEquals("John", player.getName());
        assertEquals(0, player.getScore());
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());
    }

    @Test
    public void testPlayerMovement() {
        Player player = new Player("John", 2, 2);
        player.move("up", 5);
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());

        player.move("down", 5);
        assertEquals(2, player.getX());
        assertEquals(2, player.getY());

        player.move("left", 5);
        assertEquals(2, player.getX());
        assertEquals(1, player.getY());

        player.move("right", 5);
        assertEquals(2, player.getX());
        assertEquals(2, player.getY());
    }

    @Test
    public void testPlayerMovementWithinBounds() {
        Player player = new Player("John", 0, 0);
        player.move("up", 5);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        
        player.move("left", 5);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

    @Test
    public void testInvalidDirection() {
        Player player = new Player("John", 1, 1);
        player.move("invalid", 5);
        assertEquals(1, player.getX());
        assertEquals(1, player.getY());
    }
}

// GameWorldTest.java
import org.junit.Test;

import static org.junit.Assert.assertEquals;

