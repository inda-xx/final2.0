package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player(5, 5);
        assertEquals(5, player.getX());
        assertEquals(5, player.getY());
        assertEquals(0, player.getScore());
    }

    @Test
    public void testPlayerMovement() {
        Player player = new Player(0, 0);
        player.moveUp();
        assertEquals(-1, player.getY());
        player.moveDown();
        assertEquals(0, player.getY());
        player.moveLeft();
        assertEquals(-1, player.getX());
        player.moveRight();
        assertEquals(0, player.getX());
    }

    @Test
    public void testIncreaseScore() {
        Player player = new Player(0, 0);
        player.increaseScore(10);
        assertEquals(10, player.getScore());
        player.increaseScore(5);
        assertEquals(15, player.getScore());
    }
}

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.List;

