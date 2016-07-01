package pr05_1;

public class Dough {
    private String flourType;
    private String bakingTehnique;
    private int weight;

    public Dough(String flourType, String bakingTehnique, int weight) {
        this.setFlourType(flourType);
        this.setBakingTehnique(bakingTehnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {

        if (!flourType.equalsIgnoreCase("white") && !flourType.equalsIgnoreCase("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTehnique(String bakingTehnique) {

        if (!bakingTehnique.equalsIgnoreCase("crispy") &&
                !bakingTehnique.equalsIgnoreCase("chewy") &&
                !bakingTehnique.equalsIgnoreCase("homemade")) {

            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTehnique = bakingTehnique;
    }

    private void setWeight(int weight) {

        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double getCalories() {
        return 2 * this.weight * this.getModifier(this.flourType) * this.getModifier(this.bakingTehnique);
    }

    private double getModifier(String type) {
        switch (type.toLowerCase()) {
            case "white":
                return 1.5;
            case "wholegrain":
                return 1.0;
            case "crispy":
                return 0.9;
            case "chewy":
                return 1.1;
            case "homemade":
                return 1.0;
            default:
                return 1;
        }
    }
}
