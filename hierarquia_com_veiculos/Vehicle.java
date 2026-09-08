import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    public static final double GALLON_TO_LITER_COEFFICIENT = 0.425f;

    private List<String> passengers;
    private double fuelCap;
    private double mpg;

    public Vehicle(double fuelCap, double mpg) {
        this.passengers = new ArrayList<>();
        this.fuelCap = fuelCap;
        this.mpg = mpg;
    }

    public void addPassenger(String passenger) {
        this.passengers.add(passenger);
    }

    public void removePassenger(String passenger) {
        this.passengers.remove(passenger);
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public double getFuelCap() {
        return fuelCap;
    }

    public double getMilesPerGallon() {
        return mpg;
    }

    public double getTotalDistance() {
        return fuelCap * (mpg * GALLON_TO_LITER_COEFFICIENT);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Vehicle:\n");
        sb.append("  Passengers: ").append(String.join(", ", passengers)).append("\n");
        sb.append("  Fuel Capacity: ").append(String.format("%.2f", fuelCap)).append(" L\n");
        sb.append("  Miles per Gallon: ").append(String.format("%.2f", fuelCap)).append(" M/G\n");
        sb.append("  Total Distance: ").append(String.format("%.2f", getTotalDistance())).append(" Miles\n");
        return sb.toString();
    }
}
