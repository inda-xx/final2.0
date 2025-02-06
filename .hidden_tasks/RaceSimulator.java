import java.util.Random;

public class RaceSimulator {
    private static Random random = new Random();

    public static void race(F1Car car1, F1Car car2) {
        double car1Time = calculateRaceTime(car1);
        double car2Time = calculateRaceTime(car2);

        System.out.println(car1.getName() + " finished in " + String.format("%.2f", car1Time) + " seconds");
        System.out.println(car2.getName() + " finished in " + String.format("%.2f", car2Time) + " seconds");

        if (car1Time < car2Time) {
            System.out.println(car1.getName() + " wins!");
        } else {
            System.out.println(car2.getName() + " wins!");
        }
    }

    private static double calculateRaceTime(F1Car car) {
        double baseTime = 100 / (car.getAcceleration() * car.getMaxSpeed());
        double handlingFactor = 1 - (car.getHandling() / 100.0);
        double weatherEffect = random.nextDouble() < 0.3 ? 1.1 : 1.0;

        return baseTime * handlingFactor * weatherEffect;
    }

    public static void main(String[] args) {
        F1Car car1 = new F1Car("Ferrari F1-75", 340, 3.2, 85);
        F1Car car2 = new F1Car("Red Bull RB18", 345, 3.0, 90);

        race(car1, car2);
    }
}