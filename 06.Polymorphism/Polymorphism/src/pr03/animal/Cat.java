package pr03.animal;

import pr03.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eatFood(Food food) {
        int currFood = this.getFoodEaten();
        if (food.getQuantity() > 0) {
            this.setFoodEaten(currFood + food.getQuantity());
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.######");

        return String.format("%s[%s, %s, %s, %s, %s]",
                getClass().getSimpleName(),
                this.getAnimalName(),
                this.getBreed(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
