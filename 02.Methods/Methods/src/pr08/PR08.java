package pr08;

import java.util.Scanner;

class Car {
    private double speed;
    private double fuel;
    private double fuelEconomy;
    private double distance;
    private double time;

    public Car(double speed, double fuel, double fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
    }

    public double getFuel() {
        return fuel;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    // Distance = (fuel * 100) / economy
    // Litres = distance * (economy / 100)

    void travel(double km) {
        double canTravel = (this.fuel * 100) / this.fuelEconomy;

        if (canTravel > km){
            canTravel = km;
        }

        this.distance += canTravel;
        this.fuel -= (canTravel * (this.fuelEconomy / 100));

        this.time += (canTravel / this.speed) * 60;
    }

    void refuel(double litters){
        this.fuel += litters;
    }

}

public class PR08 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] carTokens = input.nextLine().split("[\\s]+");
        Car car = new Car(Double.parseDouble(carTokens[0]), Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));

        while (true){
            String line = input.nextLine();

            if (line.equals("END")){
                break;
            }

            String[] carCommands = line.split("[\\s]+");

            switch (carCommands[0]){
                case "Travel":
                    double dist = Double.parseDouble(carCommands[1]);
                    car.travel(dist);
                    break;
                case "Refuel":
                    double ref = Double.parseDouble(carCommands[1]);
                    car.refuel(ref);
                    break;
                case "Distance":
                    System.out.printf("Total distance: %.1f kilometers%n", car.getDistance());
                    break;
                case "Time":
                    System.out.printf("Total time: %d hours and %d minutes%n", (int)car.getTime() / 60, (int)car.getTime() % 60);
                    break;
                case "Fuel":
                    System.out.printf("Fuel left: %.1f liters%n", car.getFuel());
                    break;
            }
        }
    }
}
