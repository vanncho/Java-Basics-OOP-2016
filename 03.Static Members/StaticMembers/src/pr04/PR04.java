package pr04;

import java.util.Scanner;

class BeerCounter{
    static int beerInStock;
    static int beersDrankCount;

    static void buyBeer(int bottlesCount){
        beerInStock += bottlesCount;
    }

    static void drinkBeer(int bottlesCount){
        beersDrankCount += bottlesCount;
        beerInStock -= bottlesCount;
    }
}

public class PR04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        while (!line.equals("End")){
            String[] beers = line.split("[\\s]+");
            int beersBought = Integer.valueOf(beers[0]);
            int beersDrank = Integer.valueOf(beers[1]);

            BeerCounter.buyBeer(beersBought);
            BeerCounter.drinkBeer(beersDrank);

            line = input.nextLine();
        }

        System.out.printf("%d %d", BeerCounter.beerInStock, BeerCounter.beersDrankCount);
    }
}
