public class OffRoad extends Vehicle{

    private double groundClearance;

    public OffRoad(double fuelCap, double mpg, double groundClearance) {
        super(fuelCap, mpg);
        this.groundClearance = groundClearance;
    }

    public double getGroundClearance() {
        return groundClearance;
    }

    @Override
    public String toString() {
        String  str = super.toString();
        str = str + "  Type: Off-road\n  Ground Clearance: " + String.format("%.2f", groundClearance) + " cm";
        return str;
    }
}
