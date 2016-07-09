package pr04_FactoryPattern.mood;

public class MoodFactory {

    public Mood createMood(int points) {

        Mood mood = null;

        if (points < -5) {
            mood = new Angry();
        } else if (points >= -5 && points < 0) {
            mood = new Sad();
        } else if (points >= 0 && points <= 15) {
            mood = new Happy();
        } else {
            mood = new JavaScript();
        }

        return mood;
    }
}
