package pr05;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> topping;
    private int numOfToppings;

    public Pizza(String name, Dough dough, List<Topping> topping, int numOfToppings) {
        this.setName(name);
        this.setDough(dough);
        this.setTopping(topping);
        this.setNumOfToppings(numOfToppings);
    }

    public Pizza(String name, int numOfToppings) {
        this(name, null, null, numOfToppings);
    }

    public void setName(String name) {

        if (name == null || name.trim().length() == 0 || name.trim().length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setTopping(List<Topping> topping) {
        this.topping = new ArrayList<>();
    }

    public void setNumOfToppings(int numOfToppings) {

        if (numOfToppings < 0 || numOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.numOfToppings = numOfToppings;
    }

    public double getTotalCalories(Dough dough, List<Topping> toppingsList){

        double doughCals = dough.calculateCalories(dough);
        double toppingsCals = 0d;

        for (Topping topping : toppingsList) {
            toppingsCals += topping.calculateCalories(topping);
        }

        return doughCals + toppingsCals;
    }
}
