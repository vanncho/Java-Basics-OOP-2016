package pr01;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public static final double CLIMATE = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void driveDistance(double distance) {
        double currConsumption = this.getFuelConsumption() + CLIMATE;
            double traveledDistance = distance * currConsumption;
        DecimalFormat df = new DecimalFormat("0.######");

            if (traveledDistance <= this.getFuelQuantity()) {
                System.out.printf("Truck travelled %s km%n", df.format(distance));
                double temp = getFuelQuantity() - traveledDistance;
                this.setFuelQuantity(temp);
            } else {
                System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuelWithLiters(double liters) {
        super.refuelWithLiters(liters - (liters * 0.05d));
    }
}
