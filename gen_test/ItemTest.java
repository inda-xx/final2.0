package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void testItemInitialization() {
        Item i = new Item(1, 2, 10);
        assertEquals(1, i.getX());
        assertEquals(2, i.getY());
        assertEquals(10, i.getValue());
    }
}

// File: GameLoaderTest.java
import org.junit.Test;
import java.util.List;
import java.io.*;
import static org.junit.Assert.*;

