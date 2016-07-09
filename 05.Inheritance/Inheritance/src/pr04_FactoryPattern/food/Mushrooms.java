package pr04_FactoryPattern.food;

public class Mushrooms extends Food {
    private static int POINTS_OF_HAPPINESS = -10;

    public Mushrooms() {
    }

    @Override
    public int givePointsOfHappiness() {
        return POINTS_OF_HAPPINESS;
    }
}
