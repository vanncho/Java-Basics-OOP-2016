package pr02;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public static final double CLIMATE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
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

    @Override
    public void refuelWithLiters(double liters) {

        if ((this.getFuelQuantity() + liters) > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            double fuel = getFuelQuantity() + liters;
            setFuelQuantity(fuel);
        }
    }
}
