package pr04_FactoryPattern;

import pr04_FactoryPattern.food.Food;
import pr04_FactoryPattern.food.FoodFactory;
import pr04_FactoryPattern.mood.MoodFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] foodTokens = reader.readLine().split("[\\s]+");

        FoodFactory foodFactory = new FoodFactory();
        MoodFactory moodFactory = new MoodFactory();

        int points = 0;
        for (int i = 0; i < foodTokens.length; i++) {
            String food = foodTokens[i];

            Food currFood = foodFactory.createFood(food.toLowerCase());
            points += currFood.givePointsOfHappiness();
        }

        System.out.println(points);
        System.out.println(moodFactory.createMood(points).getClass().getSimpleName());
    }
}
