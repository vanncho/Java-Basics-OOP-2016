package pr11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

abstract class Cat {
    protected String name;

    Cat(String name){
        this.name = name;
    }
}

class Siamese extends Cat{
    private String earSize;

    Siamese(String name, String earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %s", this.name, this.earSize);
    }
}

class Cymric extends Cat{
    private String furLength;

    Cymric(String name, String furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %s", this.name, this.furLength);
    }
}

class StreetExtraordinaire extends Cat{
    private String decibelsOfMeows;

    StreetExtraordinaire(String name, String decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %s", this.name, this.decibelsOfMeows);
    }
}

public class PR11 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Cat> dataOfCats = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("End")){
            String[] tokens = input.split("[\\s]+");
            String bread = tokens[0];
            String name = tokens[1];
            String type = tokens[2];
            Cat cat = null;

            switch (bread){
                case "Siamese":
                    cat = new Siamese(name, type);
                    break;
                case "Cymric":
                    cat = new Cymric(name, type);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, type);
                    break;
            }

            dataOfCats.put(name, cat);
            input = reader.readLine();
        }

        String searchedCat = reader.readLine();
        System.out.println(dataOfCats.get(searchedCat));
    }
}
