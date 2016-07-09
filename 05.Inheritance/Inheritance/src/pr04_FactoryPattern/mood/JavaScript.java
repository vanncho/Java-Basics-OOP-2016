package pr04_FactoryPattern.mood;

public class JavaScript extends Mood {
    private static String MOOD_NAME = "JavaScript";

    public JavaScript() {
    }

    @Override
    public String getMoodName() {
        return MOOD_NAME;
    }
}
