package pr03;

import java.util.Scanner;

class Number{
    private int number;

    Number(int number){
        this.number = number;
    }

    String getNameOfLastDigit(){

        int lastDigit = this.number % 10;

        switch (lastDigit){
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";

        }

        return "no such digit";
    }
}

public class PR03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        Number num = new Number(n);
        System.out.println(num.getNameOfLastDigit());
    }
}
