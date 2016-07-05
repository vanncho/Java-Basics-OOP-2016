package pr03.animal;

import pr03.food.Food;

public class Tiger extends Felime {

    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {

        if (((Food)food).getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }

        int currFood = this.getFoodEaten();
        if (food.getQuantity() > 0) {
            this.setFoodEaten(currFood + food.getQuantity());
        }
    }
}
