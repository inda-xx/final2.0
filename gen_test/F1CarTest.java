package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class F1CarTest {
    @Test
    public void testCarInitialization() {
        F1Car car = new F1Car("Ferrari", 350, 3.3, 90);
        assertEquals("Ferrari", car.getName());
        assertEquals(350, car.getMaxSpeed());
        assertEquals(3.3, car.getAcceleration(), 0.01);
        assertEquals(90, car.getHandling());
    }

    @Test
    public void testToStringMethod() {
        F1Car car = new F1Car("Ferrari", 350, 3.3, 90);
        String expected = "Ferrari: Max Speed = 350 km/h, Acceleration = 3.3s, Handling = 90";
        assertEquals(expected, car.toString());
    }
}