package pr03;

import pr03.animal.*;
import pr03.food.Food;
import pr03.food.Meat;
import pr03.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] line = reader.readLine().split("[\\s]+");

            if (line[0].equals("End")) {
                break;
            }

            String[] foodTokens = reader.readLine().split("[\\s]+");

            Animal animal = null;
            Food food = null;

            switch (foodTokens[0].toLowerCase()) {
                case "vegetable":
                    food = new Vegetable(Integer.valueOf(foodTokens[1]));
                    break;
                case "meat":
                    food = new Meat(Integer.valueOf(foodTokens[1]));
                    break;
            }

            String animalType = line[0];
            String animalName = line[1];
            double animalWeight = Double.valueOf(line[2]);
            String livingRegion = line[3];

            switch (animalType.toLowerCase()) {
                case "cat":
                    String breed = line[4];
                    animal = new Cat(animalName, animalWeight, livingRegion, breed);
                    break;
                case "tiger":
                    animal = new Tiger(animalName, animalWeight, livingRegion);
                    break;
                case "zebra":
                    animal = new Zebra(animalName, animalWeight, livingRegion);
                    break;
                case "mouse":
                    animal = new Mouse(animalName, animalWeight, livingRegion);
                    break;
            }

            if (animal != null && food != null) {
                animal.makeSound();
                try {
                    animal.eatFood(food);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
                System.out.println(animal);
            }
        }
    }
}
