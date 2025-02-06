package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RaceSimulatorTest {
    private F1Car car1;
    private F1Car car2;

    @Before
    public void setUp() {
        car1 = new F1Car("Ferrari F1-75", 340, 3.2, 85);
        car2 = new F1Car("Red Bull RB18", 345, 3.0, 90);
    }

    @Test
    public void testRaceTimeCalculation() {
        double time1 = RaceSimulator.calculateRaceTime(car1);
        double time2 = RaceSimulator.calculateRaceTime(car2);

        assertTrue(time1 > 0);
        assertTrue(time2 > 0);
    }

    @Test
    public void testRaceOutcome() {
        double time1 = RaceSimulator.calculateRaceTime(car1);
        double time2 = RaceSimulator.calculateRaceTime(car2);

        if (time1 < time2) {
            assertEquals(car1.getName(), RaceSimulator.getWinner(car1, car2).getName());
        } else {
            assertEquals(car2.getName(), RaceSimulator.getWinner(car1, car2).getName());
        }
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

