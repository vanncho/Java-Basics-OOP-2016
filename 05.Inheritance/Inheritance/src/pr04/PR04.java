package pr04;

import java.util.Scanner;

public class PR04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] tokens = input.nextLine().split("[\\s]+");

//        •	Cram: 2 points of happiness;
//        •	Lembas: 3 points of happiness;
//        •	Apple: 1 point of happiness;
//        •	Melon: 1 point of happiness;
//        •	HoneyCake: 5 points of happiness;
//        •	Mushrooms: -10 points of happiness;
//        •	Everything else: -1 point of happiness;

        int totalPoints = 0;

        for (int i = 0; i < tokens.length; i++) {
            String currFood = tokens[i].toLowerCase();

            int currPoints;
            switch (currFood){
                case "cram":
                    currPoints = 2;
                    break;
                case "lembas":
                    currPoints = 3;
                    break;
                case "apple":
                    currPoints = 1;
                    break;
                case "melon":
                    currPoints = 1;
                    break;
                case "honeycake":
                    currPoints = 5;
                    break;
                case "mushrooms":
                    currPoints = -10;
                    break;
                default:
                    currPoints = -1;
                    break;
            }

            totalPoints += currPoints;
        }

        System.out.println(totalPoints);
        if (totalPoints < -5){
            System.out.println("Angry");
        } else if(totalPoints >= -5 && totalPoints < 0){
            System.out.println("Sad");
        } else if(totalPoints >= 0 && totalPoints < 15){
            System.out.println("Happy");
        } else {
            System.out.println("JavaScript ");
        }
    }
}
