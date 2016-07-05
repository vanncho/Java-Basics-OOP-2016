package pr02;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {

        if (fuelQuantity < 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public abstract void driveDistance(double distance);

    public void refuelWithLiters(double liters) {
        this.fuelQuantity += liters;
    }
}
