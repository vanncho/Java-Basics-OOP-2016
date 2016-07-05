package pr03.animal;

import pr03.food.Food;

public class Mouse extends Mammal {

    public Mouse(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood(Food food) {

        if (((Food)food).getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Mouses are not eating that type of food!");
        }

        //if (food.getQuantity() <= 0) {
        //    throw new IllegalArgumentException("A cheese was just eaten!");
        //}

        int currFood = this.getFoodEaten();
        if (food.getQuantity() > 0) {
            this.setFoodEaten(currFood + food.getQuantity());
        }
    }
}
