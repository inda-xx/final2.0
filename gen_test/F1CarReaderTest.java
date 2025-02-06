package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class F1CarReaderTest {
    private static final String TEST_FILE = "test_cars.txt";

    @Before
    public void setUp() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("Name,MaxSpeed,Acceleration,Handling\n");
            writer.write("Ferrari F1-75,340,3.2,85\n");
            writer.write("Red Bull RB18,345,3.0,90\n");
            writer.write("Mercedes W13,335,3.1,88\n");
            writer.write("InvalidCar,invalid,3.5,80\n");
        }
    }

    @Test
    public void testReadCarsFromFileValidData() {
        List<F1Car> cars = F1CarReader.readCarsFromFile(TEST_FILE);
        assertEquals(3, cars.size());
        assertEquals("Ferrari F1-75", cars.get(0).getName());
        assertEquals(340, cars.get(0).getMaxSpeed());
        assertEquals(3.2, cars.get(0).getAcceleration(), 0.01);
        assertEquals(85, cars.get(0).getHandling());
    }

    @Test
    public void testReadCarsFromFileHandlesInvalidDataGracefully() {
        List<F1Car> cars = F1CarReader.readCarsFromFile(TEST_FILE);
        assertEquals(3, cars.size());  
    }

    @Test
    public void testReadCarsFromFileWithNonexistentFile() {
        List<F1Car> cars = F1CarReader.readCarsFromFile("nonexistent.txt");
        assertTrue(cars.isEmpty());
    }
}

import org.junit.Test;
import org.junit.Before;

import java.util.*;

import static org.junit.Assert.*;

