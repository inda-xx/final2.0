public class F1Car {
    private String name;
    private int maxSpeed;
    private double acceleration;
    private int handling;

    public F1Car(String name, int maxSpeed, double acceleration, int handling) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.handling = handling;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public int getHandling() {
        return handling;
    }

    @Override
    public String toString() {
        return name + ": Max Speed = " + maxSpeed + " km/h, Acceleration = " + acceleration 
               + "s, Handling = " + handling;
    }
}