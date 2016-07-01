package pr10;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

class DateModifier {
    private long diff;

    public long getDiff() {
        return diff;
    }

    void differenceBetweenDates(String dayOne, String dayTwo) {

        String[] dayOneTokens = dayOne.split("[\\s]+");
        String[] dayTwoTokens = dayTwo.split("[\\s]+");

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Integer.valueOf(dayOneTokens[0]), Integer.valueOf(dayOneTokens[1]), Integer.valueOf(dayOneTokens[2]));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Integer.valueOf(dayTwoTokens[0]), Integer.valueOf(dayTwoTokens[1]), Integer.valueOf(dayTwoTokens[2]));

        long milliSec1 = calendar1.getTimeInMillis();
        long milliSec2 = calendar2.getTimeInMillis();

        long timeDifInMilliSec;
        if (milliSec1 >= milliSec2) {
            timeDifInMilliSec = milliSec1 - milliSec2;
        } else {
            timeDifInMilliSec = milliSec2 - milliSec1;

        }

        long timeDifDays = timeDifInMilliSec / (24 * 60 * 60 * 1000);
        this.diff = timeDifDays;
    }
}

public class PR10 {
    public static void main(String[] args) {

        Locale.setDefault(new Locale("fr", "FRANCE", "MAC"));
        Scanner input = new Scanner(System.in);
        String first = input.nextLine();
        String second = input.nextLine();
        //Locale.setDefault(Locale.ROOT);

        DateModifier dateModifier = new DateModifier();
        dateModifier.differenceBetweenDates(first, second);
        System.out.println(dateModifier.getDiff());
    }
}
