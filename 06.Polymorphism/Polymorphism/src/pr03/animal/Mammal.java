package pr03.animal;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;
    
    public Mammal(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.#########");

        return String.format("%s[%s, %s, %s, %s]",
                getClass().getSimpleName(),
                this.getAnimalName(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
