package pr04_FactoryPattern.food;

public class EverythingElse extends Food {
    private static int POINTS_OF_HAPPINESS = -1;

    public EverythingElse() {
    }

    @Override
    public int givePointsOfHappiness() {
        return POINTS_OF_HAPPINESS;
    }
}
