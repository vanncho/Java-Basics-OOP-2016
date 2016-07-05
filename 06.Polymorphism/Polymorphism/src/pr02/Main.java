package pr02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split("[\\s]+");
        Vehicle car = new Car(Double.valueOf(carTokens[1]), Double.valueOf(carTokens[2]), Double.valueOf(carTokens[3]));

        String[] truckTokens = reader.readLine().split("[\\s]+");
        Vehicle truck = new Truck(Double.valueOf(truckTokens[1]), Double.valueOf(truckTokens[2]), Double.valueOf(truckTokens[3]));

        String[] busTokens = reader.readLine().split("[\\s]+");
        Vehicle bus = new Bus(Double.valueOf(busTokens[1]), Double.valueOf(busTokens[2]), Double.valueOf(busTokens[3]));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("[\\s+]");
            String command = tokens[0];
            String vehicle = tokens[1];

            if (tokens.length == 3) {
                double quantity = Double.valueOf(tokens[2]);

                if (vehicle.equals("Car")) {

                    if (command.equals("Drive")) {
                        car.driveDistance(quantity);
                    } else {
                        car.refuelWithLiters(quantity);
                    }

                } else if (vehicle.equals("Truck")) {

                    if (command.equals("Drive")) {
                        truck.driveDistance(quantity);
                    } else {
                        truck.refuelWithLiters(quantity);
                    }
                } else if (vehicle.equals("Bus")) {

                    if (command.equals("Drive")) {
                        bus.driveDistance(quantity);
                    } else if (command.equals("DriveEmpty")) {

                        ((Bus)bus).driveEmpty(quantity);
                    } else {
                        bus.refuelWithLiters(quantity);
                    }
                }
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }
}
