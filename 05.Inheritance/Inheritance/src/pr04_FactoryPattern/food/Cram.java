package pr04_FactoryPattern.food;

public class Cram extends Food {
    private static int POINTS_OF_HAPPINESS = 2;

    public Cram() {
    }

    @Override
    public int givePointsOfHappiness() {
        return POINTS_OF_HAPPINESS;
    }
}
