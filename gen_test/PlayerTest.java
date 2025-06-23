package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testPlayerInitialization() {
        Player p = new Player(1, 2);
        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
        assertEquals(3, p.getHealth());
        assertEquals(0, p.getScore());
    }

    @Test
    public void testPlayerMoveWithinBounds() {
        Player p = new Player(2, 2);
        p.move('W', 5, 5);
        assertEquals(1, p.getY());
        p.move('S', 5, 5);
        assertEquals(2, p.getY());
        p.move('A', 5, 5);
        assertEquals(1, p.getX());
        p.move('D', 5, 5);
        assertEquals(2, p.getX());
    }

    @Test
    public void testPlayerMoveBoundaryConditions() {
        Player p = new Player(0, 0);
        p.move('W', 5, 5);
        assertEquals(0, p.getY());
        p.move('A', 5, 5);
        assertEquals(0, p.getX());
        p = new Player(4, 4);
        p.move('S', 5, 5);
        assertEquals(4, p.getY());
        p.move('D', 5, 5);
        assertEquals(4, p.getX());
    }

    @Test
    public void testCollectItemIncreasesScore() {
        Player p = new Player(0, 0);
        assertEquals(0, p.getScore());
        p.collect(new Item(0, 0, 5));
        assertEquals(5, p.getScore());
        p.collect(new Item(0, 0, 10));
        assertEquals(15, p.getScore());
    }

    @Test
    public void testHealthModification() {
        Player p = new Player(0, 0);
        p.setHealth(2);
        assertEquals(2, p.getHealth());
    }
}

// File: ItemTest.java
import org.junit.Test;
import static org.junit.Assert.*;

