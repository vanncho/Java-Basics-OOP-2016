package pr06;

import java.util.Scanner;

public class PR06 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        Number n = new Number(num, false);
        System.out.println(n);
    }
}
