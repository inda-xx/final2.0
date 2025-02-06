import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;

public class RaceTrack {
    private List<F1Car> cars;
    private int laps;
    private Random random;

    public RaceTrack(List<F1Car> cars, int laps) {
        this.cars = cars;
        this.laps = laps;
        this.random = new Random();
    }

    public void startRace() {
        Map<F1Car, Double> raceTimes = new HashMap<>();

        for (F1Car car : cars) {
            raceTimes.put(car, 0.0);
        }

        for (int lap = 1; lap <= laps; lap++) {
            System.out.println("Lap " + lap + " begins!");

            for (F1Car car : cars) {
                double lapTime = calculateLapTime(car);
                raceTimes.put(car, raceTimes.get(car) + lapTime);

                System.out.println(car.getName() + " completed lap in " + String.format("%.2f", lapTime) + " seconds.");
            }

            System.out.println("---------------------");
        }

        declareWinner(raceTimes);
    }

    private double calculateLapTime(F1Car car) {
        double baseTime = 100 / (car.getAcceleration() * car.getMaxSpeed());
        double handlingFactor = 1 - (car.getHandling() / 100.0);
        double weatherEffect = random.nextDouble() < 0.3 ? 1.1 : 1.0;

        return baseTime * handlingFactor * weatherEffect;
    }

    private void declareWinner(Map<F1Car, Double> raceTimes) {
        F1Car winner = null;
        double bestTime = Double.MAX_VALUE;

        for (Map.Entry<F1Car, Double> entry : raceTimes.entrySet()) {
            if (entry.getValue() < bestTime) {
                bestTime = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\n🏆 Race Winner: " + winner.getName() + " with a total time of " + String.format("%.2f", bestTime) + " seconds! 🏆");
    }

    public static void main(String[] args) {
        List<F1Car> cars = new ArrayList<>();
        cars.add(new F1Car("Ferrari F1-75", 340, 3.2, 85));
        cars.add(new F1Car("Red Bull RB18", 345, 3.0, 90));
        cars.add(new F1Car("Mercedes W13", 335, 3.1, 88));

        RaceTrack race = new RaceTrack(cars, 5);
        race.startRace();
    }
}