package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RaceTrackTest {
    private List<F1Car> cars;
    private RaceTrack raceTrack;

    @Before
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new F1Car("Ferrari F1-75", 340, 3.2, 85));
        cars.add(new F1Car("Red Bull RB18", 345, 3.0, 90));
        cars.add(new F1Car("Mercedes W13", 335, 3.1, 88));

        raceTrack = new RaceTrack(cars, 5);
    }

    @Test
    public void testRaceTrackInitializedCorrectly() {
        assertEquals(3, cars.size());
        assertEquals(5, raceTrack.getLaps());
    }

    @Test
    public void testLapTimeCalculation() {
        F1Car car = new F1Car("Test Car", 300, 3.5, 80);
        double lapTime = raceTrack.calculateLapTime(car);
        assertTrue(lapTime > 0);
    }

    @Test
    public void testDeclareWinner() {
        Map<F1Car, Double> raceTimes = new HashMap<>();
        raceTimes.put(cars.get(0), 150.5);
        raceTimes.put(cars.get(1), 145.0);
        raceTimes.put(cars.get(2), 148.0);

        assertEquals("Red Bull RB18", raceTrack.getWinner(raceTimes).getName());
    }
}

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

