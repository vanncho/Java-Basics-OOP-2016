package pr05_1;

import java.util.LinkedList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private int toppingsCount;
    private List<Topping> toppings;

    public Pizza(String name, int toppingsCount) {
        this.setName(name);
        this.setToppingsCount(toppingsCount);
        this.toppings = new LinkedList<>();
    }

    public double getCalories(){
        double total = this.dough.getCalories();
        for (Topping topping : toppings) {
            total += topping.getCalories();
        }

        return total;
    }

    public void setDough(Dough dough){
        this.dough = dough;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    private void setToppingsCount(int toppingsCount) {
        if (toppingsCount > 10 || toppingsCount < 0){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingsCount = toppingsCount;
    }

    private void setName(String name) {

        if (name == null || name.trim().length() == 0 || name.trim().length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols");
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f Calories.", this.name, this.getCalories());
    }
}
