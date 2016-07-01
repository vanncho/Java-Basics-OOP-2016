package pr05_1;

public class Topping {
    private String type;
    private int weight;

    public Topping(String type, int weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    private void setType(String type) {

        if (!type.equalsIgnoreCase("meat") && !type.equalsIgnoreCase("veggies") &&
                !type.equalsIgnoreCase("cheese") && !type.equalsIgnoreCase("sauce")){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setWeight(int weight) {

        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException("Meat weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double getCalories(){
        return 2 * this.weight * this.getModifier(this.type);
    }

    private double getModifier(String type){
        switch (type.toLowerCase()){
            case "meat":
                return 1.2;
            case "veggies":
                return 0.8;
            case "cheese":
                return 1.1;
            case "sauce":
                return 0.9;
            default:
                return 1;
        }
    }
}
