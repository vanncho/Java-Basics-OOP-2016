package pr04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PR04 {
    public static void main(String[] args) {

        try {
            LinkedHashMap<String, Person> personsList = new LinkedHashMap<>();
            LinkedHashMap<String, Product> productsList = new LinkedHashMap<>();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] namesTokens = reader.readLine().split(";");

            for (int i = 0; i < namesTokens.length; i++) {
                String[] tokens = namesTokens[i].split("=");
                Person currPerson = new Person(tokens[0], Double.valueOf(tokens[1]));

                if (!personsList.containsKey(tokens[0])){
                    personsList.put(tokens[0], currPerson);
                }
            }

            String[] productsTokens = reader.readLine().split(";");

            for (int i = 0; i < productsTokens.length; i++) {
                String[] tokens = productsTokens[i].split("=");
                Product currProduct = new Product(tokens[0], Double.valueOf(tokens[1]));
                productsList.put(tokens[0], currProduct);
            }

            while (true){
                String[] line = reader.readLine().split("[\\s]+");

                if (line[0].equals("END")){
                    break;
                }

                String name = line[0];
                String productToBuy = line[1];

                Person currPerson = personsList.get(name);
                Product currProduct = productsList.get(productToBuy);

                currPerson.addProductToBag(currProduct);
            }

            for (Map.Entry<String, Person> stringPersonEntry : personsList.entrySet()) {
                System.out.printf("%s - ", stringPersonEntry.getKey());

                Person p = stringPersonEntry.getValue();

                if (p.getBag().size() > 0){
                    System.out.println(p.getBag().toString().substring(1, p.getBag().toString().length() - 1));
                } else {
                    System.out.printf("Nothing bought%n", p.getName());
                }
            }

        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
