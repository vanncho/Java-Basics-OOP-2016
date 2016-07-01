package pr05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PR05 {
    public static void main(String[] args) {

        try{
            Scanner input = new Scanner(System.in);

            int numberOfToppings = 0;
            String pizzaName = null;
            Dough currDough = null;
            List<Topping> list = new ArrayList<>();
            boolean finish = false;

            while (true){
                String line = input.nextLine();

                if(line.equals("END")){
                    break;
                }

                String[] tokens = line.split("[\\s]+");

                switch (tokens[0]){
                    case "Dough":
                        currDough = new Dough(tokens[1], tokens[2], Double.valueOf(tokens[3]));
                        System.out.println(currDough.calculateCalories(currDough));
                        break;
                    case "Topping":
                        while (true){
                            String[] toppingComponents = line.split("[\\s]+");

                            if (!toppingComponents[0].equals("Topping")){
                                break;
                            }

                            Topping currTopping = new Topping(toppingComponents[1], Double.valueOf(toppingComponents[2]));
                            System.out.println(currTopping.calculateCalories(currTopping));
                            list.add(currTopping);

                            line = input.nextLine();

                            if(line.equals("END")){
                                finish = true;
                                break;
                            }
                        }
                        break;
                    case "Pizza":
                        pizzaName = tokens[1];
                        numberOfToppings = Integer.valueOf(tokens[2]);
                        //Pizza p = new Pizza(pizzaName, numberOfToppings);

                        Pizza pizza = new Pizza(pizzaName, currDough, list, numberOfToppings);
                        System.out.printf("%s - %.2f Calories.", pizzaName, pizza.getTotalCalories(currDough, list));
                        break;
                }

                if(finish){
                    break;
                }
            }
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
