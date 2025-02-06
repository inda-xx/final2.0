import java.util.List;
import java.util.ArrayList;

public class F1CarReader {
    public static List<F1Car> readCarsFromFile(String filename) {
        List<F1Car> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    int maxSpeed = Integer.parseInt(parts[1]);
                    double acceleration = Double.parseDouble(parts[2]);
                    int handling = Integer.parseInt(parts[3]);

                    cars.add(new F1Car(name, maxSpeed, acceleration, handling));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return cars;
    }

    public static void main(String[] args) {
        List<F1Car> cars = readCarsFromFile("cars.txt");
        for (F1Car car : cars) {
            System.out.println(car);
        }
    }
}