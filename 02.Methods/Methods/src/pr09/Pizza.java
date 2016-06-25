package pr09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pizza {
    private String name;
    private int group;
    private List<String> listOfPizzas;

    Pizza(String name, int group){
        this.name = name;
        this.group = group;
        this.listOfPizzas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    void addPizzaToCollection(String pizzaAndGroup){
        this.listOfPizzas.add(pizzaAndGroup);
    }

    HashMap addPizzaParameters(){

        HashMap<Integer, List<String>> pizzaData = new HashMap<>();

        for (String listOfPizza : this.listOfPizzas) {

            String regex = "(\\d+)(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(listOfPizza);
            matcher.find();

            int group = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2);

            if (!pizzaData.containsKey(group)){
                pizzaData.put(group, new ArrayList<>());
            }
            pizzaData.get(group).add(name);
        }

        return pizzaData;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                '}';
    }
}
