package pr03.animal;

import pr03.food.Food;

public class Zebra extends Mammal {

    public Zebra(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eatFood(Food food) {

        if (((Food)food).getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }

        int currFood = this.getFoodEaten();
        if (food.getQuantity() > 0) {
            this.setFoodEaten(currFood + food.getQuantity());
        }
    }
}
