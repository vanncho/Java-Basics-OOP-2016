package pr04_FactoryPattern.mood;

public class Angry extends Mood {
    private static String MOOD_NAME = "Angry";

    public Angry() {
    }

    @Override
    public String getMoodName() {
        return MOOD_NAME;
    }
}
