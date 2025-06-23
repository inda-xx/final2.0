package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyTest {
    @Test
    public void testEnemyInitialization() {
        Enemy e = new Enemy(3, 4);
        assertEquals(3, e.getX());
        assertEquals(4, e.getY());
    }
}

// File: PlayerTest.java
import org.junit.Test;
import static org.junit.Assert.*;

