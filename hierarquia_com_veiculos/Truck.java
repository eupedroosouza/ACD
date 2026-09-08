public class Truck extends Vehicle {

    private double cargoCap;

    public Truck(double fuelCap, double mpg, double cargoCap) {
        super(fuelCap, mpg);
        this.cargoCap = cargoCap;
    }

    public double getCargoCap() {
        return cargoCap;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str = str + "  Type: Truck\n  Cargo Capacity: " + String.format("%.2f", cargoCap) + " Ton\n";
        return str;
    }
}