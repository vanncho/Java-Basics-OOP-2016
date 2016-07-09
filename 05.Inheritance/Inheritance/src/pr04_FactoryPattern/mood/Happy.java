package pr04_FactoryPattern.mood;

public class Happy extends Mood {
    private static String MOOD_NAME = "Happy";

    public Happy() {
    }

    @Override
    public String getMoodName() {
        return MOOD_NAME;
    }
}
