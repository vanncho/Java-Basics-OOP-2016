package pr04_FactoryPattern.food;

public class Lembas extends Food {
    private static int POINTS_OF_HAPPINESS = 3;

    public Lembas() {
    }

    @Override
    public int givePointsOfHappiness() {
        return POINTS_OF_HAPPINESS;
    }
}
