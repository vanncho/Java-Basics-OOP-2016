package pr05;

public class Dough {
    private static final double BASE_CALORIES = 2.0D;
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public void setFlourType(String flourType) {

        if (flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setBakingTechnique(String bakingTechnique) {

        if (bakingTechnique.equalsIgnoreCase("Crispy") || bakingTechnique.equalsIgnoreCase("Chewy") || bakingTechnique.equalsIgnoreCase("Homemade")){
            this.bakingTechnique = bakingTechnique;
        } else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }


    }

    public void setWeight(double weight) {

        if (weight >= 1 && weight <= 200){
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

    }

    public double calculateCalories(Dough dough){

        double flourTypeCal = 0d;
        if (dough.flourType.equalsIgnoreCase("White")){
            flourTypeCal = 1.5d;
        } else {
            flourTypeCal = 1.0d;
        }

        double bakingTechniqueCal = 0d;
        if (dough.bakingTechnique.equalsIgnoreCase("Crispy")){
            bakingTechniqueCal = 0.9d;
        } else if (dough.bakingTechnique.equalsIgnoreCase("Chewy")){
            bakingTechniqueCal = 1.1d;
        } else {
            bakingTechniqueCal = 1.0d;
        }

        return (BASE_CALORIES * this.weight) * flourTypeCal * bakingTechniqueCal;
    }
}
