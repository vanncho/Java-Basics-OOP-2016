package pr01;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public static final double CLIMATE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void driveDistance(double distance) {
        double currConsumption = this.getFuelConsumption() + CLIMATE;
        double traveledDistance = distance * currConsumption;
        DecimalFormat df = new DecimalFormat("0.######");

        if (traveledDistance <= this.getFuelQuantity()) {
            System.out.printf("Car travelled %s km%n", df.format(distance));
            double temp = getFuelQuantity() - traveledDistance;
            this.setFuelQuantity(temp);
        } else {
            System.out.println("Car needs refueling");
        }
    }
}
