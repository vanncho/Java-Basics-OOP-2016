package pr06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Engine{
    private int engineSpeed;
    private int enginePower;

    Engine (int engineSpeed, int enginePower){
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getEngineSpeed(){
        return engineSpeed;
    }
}

class Cargo{
    private int cargoWeight;
    private String cargoType;

    Cargo (int cargoWeight, String cargoType){
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }
}

class Tire{
    private double tirePressure;
    private int tireAge;


    Tire(double tirePressure, int tireAge){
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public int getTireAge() {
        return tireAge;
    }
}

class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tire = new Tire[4];

    Car (String model, Engine engine, Cargo cargo, Tire[] tires){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTire() {
        return tire;
    }
}

public class PR06 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Car[] carsInfo = new Car[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("[\\s]+");

            String carModel = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double t1Pressure = Double.parseDouble(tokens[5]);
            int t1Age = Integer.parseInt(tokens[6]);
            double t2Pressure = Double.parseDouble(tokens[7]);
            int t2Age = Integer.parseInt(tokens[8]);
            double t3Pressure = Double.parseDouble(tokens[9]);
            int t3Age = Integer.parseInt(tokens[10]);
            double t4Pressure = Double.parseDouble(tokens[11]);
            int t4Age = Integer.parseInt(tokens[12]);

            Engine currEngine = new Engine(engineSpeed, enginePower);
            Cargo currCargo = new Cargo(cargoWeight, cargoType);
            Tire firstTyre = new Tire(t1Pressure, t1Age);
            Tire secondTyre = new Tire(t2Pressure, t2Age);
            Tire thirdTyre = new Tire(t3Pressure, t3Age);
            Tire fourthTyre = new Tire(t4Pressure, t4Age);
            Tire[] carTires = {firstTyre, secondTyre, thirdTyre, fourthTyre};

            Car currCar = new Car(carModel, currEngine, currCargo, carTires);
            carsInfo[i] = currCar;
        }

        String type = reader.readLine();

        if (type.equals("fragile")) {
            Arrays.stream(carsInfo).filter(c -> {
                Tire[] tiresInfo = c.getTire();

                for (int i = 0; i < tiresInfo.length; i++) {
                    Tire currTire = tiresInfo[i];
                    double pressure = currTire.getTirePressure();
                    if (pressure < 1){
                        return true;
                    }
                }
                return false;
            })
                    .forEach(name -> System.out.println(name.getModel()));
        } else {
            Arrays.stream(carsInfo).filter(c -> {
                Engine currEngine = c.getEngine();
                return currEngine.getEnginePower() > 250;
            })
                    .forEach(name -> System.out.println(name.getModel()));
        }
    }
}
