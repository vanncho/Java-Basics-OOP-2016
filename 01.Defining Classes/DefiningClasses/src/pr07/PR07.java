package pr07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    Car (String model, Engine engine, int weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    Car (String model, Engine engine, int weight){
        this(model, engine, weight, null);
    }

    Car(String model, Engine engine, String color){
        this(model, engine, 0, color);
    }

    Car(String model, Engine engine){
        this(model, engine, 0, "n/a");
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine=" + engine +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}

class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    Engine (String model, int power, int displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    Engine (String model, int power, int displacement){
        this(model, power, displacement, "n/a");
    }

    Engine (String model, int power, String efficiency){
        this(model, power, 0, efficiency);
    }

    Engine (String model, int power){
        this(model, power, 0, "n/a");
    }

    public String getModel() {
        return model;
    }

    public int getPower(){
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                ", power=" + power +
                ", displacement=" + displacement +
                ", efficiency='" + efficiency + '\'' +
                '}';
    }
}

public class PR07 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int engines = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Engine> engineData = new LinkedHashMap<>();

        for (int i = 0; i < engines; i++) {
            String[] engineTokens = reader.readLine().split("[\\s]+");
            String model = engineTokens[0];
            int power = Integer.parseInt(engineTokens[1]);
            int displacement;
            String efficiency;
            Engine currEngine = null;

            switch (engineTokens.length){
                case 2:
                    currEngine = new Engine(model, power);
                    break;
                case 3:
                    if (Character.isDigit(engineTokens[2].charAt(0))){
                        displacement = Integer.parseInt(engineTokens[2]);
                        currEngine = new Engine(model, power, displacement);
                    } else {
                        efficiency = engineTokens[2];
                        currEngine = new Engine(model, power, efficiency);
                    }
                    break;
                case 4:
                    displacement = Integer.parseInt(engineTokens[2]);
                    efficiency = engineTokens[3];
                    currEngine = new Engine(model, power, displacement, efficiency);
                    break;
            }

            engineData.put(model, currEngine);
        }

        int cars = Integer.parseInt(reader.readLine());
        Car[] carData = new Car[cars];

        for (int i = 0; i < cars; i++) {
            String[] carTokens = reader.readLine().split("[\\s]+");
            String model = carTokens[0];
            String engine = carTokens[1];
            int weight;
            String color;
            Car currCar = null;
            Engine en = engineData.get(engine);

            switch (carTokens.length){
                case 2:
                    currCar = new Car(model, new Engine(engine, en.getPower(), en.getDisplacement(), en.getEfficiency()));
                    break;
                case 3:
                    if (Character.isDigit(carTokens[2].charAt(0))){
                        weight = Integer.parseInt(carTokens[2]);
                        currCar = new Car(model, new Engine(engine, en.getPower(), en.getDisplacement(), en.getEfficiency()), weight);
                    } else {
                        color = carTokens[2];
                        currCar = new Car(model, new Engine(engine, en.getPower(), en.getDisplacement(), en.getEfficiency()), color);
                    }
                    break;
                case 4:
                    weight = Integer.parseInt(carTokens[2]);
                    color = carTokens[3];
                    currCar = new Car(model, new Engine(engine, en.getPower(), en.getDisplacement(), en.getEfficiency()), weight, color);
                    break;
            }

            carData[i] = currCar;
        }

        for (int i = 0; i < carData.length; i++) {
            Car c = carData[i];
            System.out.println(c.getModel() + ":");
            Engine en = c.getEngine();
            System.out.printf("  %s:%n", en.getModel());
            System.out.printf("    Power: %d%n", en.getPower());
            System.out.printf("    Displacement: %s%n", (en.getDisplacement() != 0) ? en.getDisplacement() : "n/a");
            System.out.printf("    Efficiency: %s%n", (!en.getEfficiency().equals("n/a") ? en.getEfficiency() : "n/a"));
            System.out.printf("  Weight: %s%n", (c.getWeight() != 0) ? c.getWeight() : "n/a");
            System.out.printf("  Color: %s%n", (!c.getColor().equals("n/a")) ? c.getColor() : "n/a");
        }
    }
}
