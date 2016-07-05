package pr03.animal;

import pr03.food.Food;

public abstract class Animal {
    private String animalName;
    private double animalWeight;
    private int foodEaten;

    public Animal(String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public String getAnimalName() {
        return animalName;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();

    public abstract void eatFood(Food food);
}
