package pr05_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true){
                String[] input = reader.readLine().split("[\\s]+");

                if (input[0].equals("END")){
                    break;
                }

                String result = null;
                switch (input[0]){
                    case "Dough":
                        Dough dough = tryMakeDough(input);
                        result = String.format("%.2f", dough.getCalories());
                        break;
                    case "Topping":
                        Topping topping = tryMakeTopping(input);
                        result = String.format("%.2f", topping.getCalories());
                        break;
                    case "Pizza":
                        Pizza pizza = tryMakePizza(input);
                        result = pizza.toString();
                        break;
                }

                System.out.println(result);
            }
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private static Pizza tryMakePizza(String[] input) throws IOException {
        String name = input[1];
        int toppingCount = Integer.valueOf(input[2]);
        Pizza pizza = new Pizza(name, toppingCount);
        String[] line = reader.readLine().split("[\\s]+");
        Dough dough = tryMakeDough(line);
        pizza.setDough(dough);
        for (int i = 0; i < toppingCount; i++) {
            String[] toppInput = reader.readLine().split("[\\s]+");
            Topping topping = tryMakeTopping(toppInput);
            pizza.addTopping(topping);
        }

        return pizza;
    }

    private static Topping tryMakeTopping(String[] input) {
        String type = input[1];
        int weight = Integer.valueOf(input[2]);
        Topping topping = new Topping(type, weight);
        return topping;
    }

    private static Dough tryMakeDough(String[] input) {
        String flour = input[1];
        String tehnique = input[2];
        int weight = Integer.valueOf(input[3]);
        Dough dough = new Dough(flour, tehnique, weight);
        return dough;
    }
}
