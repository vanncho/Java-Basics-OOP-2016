package pr10;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

class DateModifier {

    long differenceBetweenDates(String dayOne, String dayTwo) {

        String[] dayOneTokens = dayOne.split("[\\s]+");
        String[] dayTwoTokens = dayTwo.split("[\\s]+");

        Calendar calendar1 = Calendar.getInstance();
        int c1Year = Integer.parseInt(dayOneTokens[0]);
        int c1Month = Integer.parseInt(dayOneTokens[1]);
        int c1Day = Integer.parseInt(dayOneTokens[2]);
        calendar1.set(c1Year, c1Month, c1Day);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Integer.parseInt(dayTwoTokens[0]), Integer.parseInt(dayTwoTokens[1]), Integer.parseInt(dayTwoTokens[2]));

        long startTime = calendar1.getTimeInMillis();
        long endTime = calendar2.getTimeInMillis();

        long timeDifInMilliSec = Math.abs(startTime - endTime);
        return timeDifInMilliSec / 1000 / 60 /60 / 24;
    }
}

public class PR10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String first = input.nextLine();
        String second = input.nextLine();
        Locale.setDefault(new Locale("fr", "FRANCE", "MAC"));

        DateModifier dateModifier = new DateModifier();
        long res = dateModifier.differenceBetweenDates(first, second);
        System.out.println(res);
    }
}
