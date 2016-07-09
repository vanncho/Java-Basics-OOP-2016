package pr04_FactoryPattern.food;

public class HoneyCake extends Food {
    private static int POINTS_OF_HAPPINESS = 5;

    public HoneyCake() {
    }

    @Override
    public int givePointsOfHappiness() {
        return POINTS_OF_HAPPINESS;
    }
}
