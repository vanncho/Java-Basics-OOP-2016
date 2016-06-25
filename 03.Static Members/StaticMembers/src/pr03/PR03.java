package pr03;

import java.util.Scanner;

class Temperature{
    static double degreese;
    static String type;

    public Temperature(double degreese, String type) {
        this.degreese = degreese;
        this.type = type;
    }

    static Temperature convertTemperature(){

        double returnDegrees = 0d;
        String returnType = null;
        if (type.equals("Celsius")){
            returnDegrees = 9.0 / 5.0 * degreese + 32;
            returnType = "Fahrenheit";
        } else {
            returnDegrees = ((degreese - 32)*5)/9;
            returnType = "Celsius";
        }
        Temperature n = new Temperature(returnDegrees, returnType);
        return n;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", degreese, type);
    }
}

public class PR03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();

        while (!line.equals("End")){
            String[] tempTokens = line.split("[\\s]+");

            Temperature currTemp = new Temperature(Double.valueOf(tempTokens[0]), tempTokens[1]);
            System.out.println(Temperature.convertTemperature());

            line = input.nextLine();
        }
    }
}
