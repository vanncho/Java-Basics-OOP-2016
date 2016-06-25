package pr04;

import java.util.Scanner;

class DecimalNumber{
    private double number;

    DecimalNumber(double number){
        this.number = number;
    }

    String reverseDigit(){

        StringBuilder sb = new StringBuilder();
        String numAsString = this.number + "";

        for (int i = numAsString.length() - 1; i >= 0; i--) {
            sb.append(numAsString.charAt(i));
        }

        if (sb.toString().startsWith("0.")){
            for (int i = 0; i < 2; i++) {
                sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }
}

public class PR04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double number = Double.parseDouble(input.nextLine());

        DecimalNumber decNum = new DecimalNumber(number);

        System.out.println(decNum.reverseDigit());
    }
}
