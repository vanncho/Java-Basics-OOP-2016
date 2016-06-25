package pr05;

import java.util.*;

class Car {
    String model;
    double fuelAmount;
    double fuelCostPerKm;
    int totalDistance;

    Car (String model, int fuelAmount, double fuelCostPerKm){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public boolean calculateDistanceToTravel(int kmsAmount){
        double totalKmToDrive = this.fuelAmount / this.fuelCostPerKm;

        if (totalKmToDrive >= kmsAmount){
            return true;
        }
        return false;
    }
}

public class pr05 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        LinkedHashMap<String, Car> carDataInfo = new LinkedHashMap<>();
        List<String> insufficient = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split("[\\s]+");
            String carModel = tokens[0];
            int carFuelAmount = Integer.parseInt(tokens[1]);
            double carFuelCostPerKm = Double.parseDouble(tokens[2]);

            Car currCar = new Car(carModel, carFuelAmount, carFuelCostPerKm);

            if (!carDataInfo.containsKey(carModel)){
                carDataInfo.put(carModel, currCar);
            }
        }

        String line = input.nextLine();
        while (!line.equals("End")){
            String[] tokens = line.split("[\\s]+");
            String carName = tokens[1];
            int distanceToDrive = Integer.parseInt(tokens[2]);

            Car carToDrive = carDataInfo.get(carName);

            if (carToDrive.calculateDistanceToTravel(distanceToDrive)){
                double totalKmToDrive = carToDrive.getFuelAmount() / carToDrive.getFuelCostPerKm();
                double fuelLeft = (totalKmToDrive - (double)distanceToDrive) * carToDrive.getFuelCostPerKm();

                carToDrive.setFuelAmount(fuelLeft);
                carToDrive.setTotalDistance(carToDrive.getTotalDistance() + distanceToDrive);

                carDataInfo.put(carName, carToDrive);

            } else {
                insufficient.add("Insufficient fuel for the drive");
            }

            line = input.nextLine();
        }

        for (String s : insufficient) {
            System.out.println(s);
        }

        for (String s : carDataInfo.keySet()) {
            System.out.printf("%s %.2f %d%n", s, carDataInfo.get(s).getFuelAmount(), carDataInfo.get(s).getTotalDistance());
        }
    }
}
