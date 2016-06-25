package pr07;

import java.util.Scanner;

class MathUtil{

    static void sum(double n1, double n2){
        System.out.printf("%.2f%n", (n1 + n2));
    }

    static void multiply(double n1, double n2){
        System.out.printf("%.2f%n", (n1 * n2));
    }

    static void percentage(double n1, double n2){
        System.out.printf("%.2f%n", (n1 * (n2 / 100)));
    }

    static void divide(double n1, double n2){
        System.out.printf("%.2f%n", (n1 / n2));
    }

    static void subtract(double n1, double n2){
        System.out.printf("%.2f%n", (n1 - n2));
    }
}

public class PR07 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true){
            String[] tokens = input.nextLine().split("[\\s+]");

            if (tokens[0].equals("End")){
                break;
            }

            String operation = tokens[0];
            double n1 = Double.valueOf(tokens[1]);
            double n2 = Double.valueOf(tokens[2]);

            switch (operation){
                case "Sum":
                    MathUtil.sum(n1, n2);
                    break;
                case "Multiply":
                    MathUtil.multiply(n1, n2);
                    break;
                case "Percentage":
                    MathUtil.percentage(n1, n2);
                    break;
                case "Divide":
                    MathUtil.divide(n1, n2);
                    break;
                case "Subtract":
                    MathUtil.subtract(n1, n2);
                    break;
            }
        }
    }
}
