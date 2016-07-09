package pr04_FactoryPattern.food;

public class Melon extends Food {
    private static int POINTS_OF_HAPPINESS = 1;

    public Melon() {
    }

    @Override
    public int givePointsOfHappiness() {
        return POINTS_OF_HAPPINESS;
    }
}
