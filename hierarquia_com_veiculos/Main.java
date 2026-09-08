public class Main {

    public static void main(String[] args) {
        Vehicle vehicle;
        vehicle = new Truck(220, 8.0, 4.0);
        vehicle.addPassenger("Pedro");
        vehicle.addPassenger("Gabriel");
        vehicle.addPassenger("Ciclano");
        vehicle.removePassenger("Gabriel");
        System.out.println(vehicle);
        vehicle = new OffRoad(40.0, 9.0, 42.0);
        vehicle.addPassenger("Pedro");
        vehicle.addPassenger("Fulano");
        System.out.println(vehicle);
    }

}
