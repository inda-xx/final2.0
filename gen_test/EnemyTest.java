package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyTest {

    @Test
    public void testEnemyInitialization() {
        Enemy enemy = new Enemy(10, 20);
        assertEquals(10, enemy.getX());
        assertEquals(20, enemy.getY());
    }

    @Test
    public void testEnemyNegativeCoordinates() {
        Enemy enemy = new Enemy(-5, -10);
        assertEquals(-5, enemy.getX());
        assertEquals(-10, enemy.getY());
    }
}

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

