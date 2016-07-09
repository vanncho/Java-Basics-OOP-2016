package pr04_FactoryPattern.mood;

public class Sad extends Mood {
    private static String MOOD_NAME = "Sad";

    public Sad() {
    }

    @Override
    public String getMoodName() {
        return MOOD_NAME;
    }
}
