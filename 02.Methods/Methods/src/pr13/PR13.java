package pr13;

import java.util.Scanner;

public class PR13 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String figure = input.nextLine();

        if (figure.equals("Square")){
            int side = Integer.parseInt(input.nextLine());
            Figure sq = new Square(side);
            sq.draw();
        } else {
            int width = Integer.parseInt(input.nextLine());
            int height = Integer.parseInt(input.nextLine());
            Figure rec = new Rectangle(width, height);
            rec.draw();
        }
    }
}
