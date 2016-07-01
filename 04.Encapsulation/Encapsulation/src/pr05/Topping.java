package pr05;

public class Topping {
    private static final double BASE_CALORIES_PER_GRAM = 2;
    private String toppingType;
    private double toppingWeight;
    private Object calories;

    public Topping(String toppingType, double toppingWeight) {
        this.setToppingType(toppingType);
        this.setToppingWeight(toppingWeight);
    }

    public void setToppingType(String toppingType) {

        if (toppingType.equalsIgnoreCase("meat") || toppingType.equalsIgnoreCase("veggies") || toppingType.equalsIgnoreCase("cheese") || toppingType.equalsIgnoreCase("sauce")){
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    public void setToppingWeight(double toppingWeight) {

        if (toppingWeight >= 1 && toppingWeight <= 50){
            this.toppingWeight = toppingWeight;
        } else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.toppingWeight = toppingWeight;
    }

    public double calculateCalories(Topping topping){

        // Meat – 1.2;
        // Veggies – 0.8;
        // Cheese – 1.1;
        // Sauce – 0.9;

        double cal = 0d;
        if (topping.toppingType.equalsIgnoreCase("meat")){
            cal = 1.2d;
        } else if (topping.toppingType.equalsIgnoreCase("veggies")){
            cal = 0.8d;
        } else if (topping.toppingType.equalsIgnoreCase("cheese")){
            cal = 1.1d;
        } else {
            cal = 0.9d;
        }

        return BASE_CALORIES_PER_GRAM * cal * this.toppingWeight;
    }
}
