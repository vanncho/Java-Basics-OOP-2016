package pr04_FactoryPattern.food;

public class Apple extends Food {
    private static int POINTS_OF_HAPPINESS = 1;

    public Apple() {
    }

    @Override
    public int givePointsOfHappiness() {
        return POINTS_OF_HAPPINESS;
    }
}
