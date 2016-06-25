package pr08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonsCollection;

    Trainer (String name, int numberOfBadges, List<Pokemon> pokemonsCollection){
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonsCollection = pokemonsCollection;
    }

    public String getName(){
        return name;
    }

    public int getNumberOfBadges(){
        return numberOfBadges;
    }

    public List getPokemonsCollection(){
        return pokemonsCollection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public void setPokemonsCollection(List<Pokemon> pokemonsCollection) {
        this.pokemonsCollection = pokemonsCollection;
    }
}

class Pokemon {
    private String name;
    private String element;
    private int health;

    Pokemon (String name, String element, int health){
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName(){
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

public class PR08 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Trainer> trainersCollection = new LinkedHashMap<>();

        String line = reader.readLine();

        if (line.equals("")){
            return;
        }

        while (!line.equals("Tournament")){
            String[] tokens = line.split("[\\s]+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon currPokemont = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            List<Pokemon> pokemonList = new ArrayList<>();
            pokemonList.add(currPokemont);
            Trainer currTrainer = new Trainer(trainerName, 0, pokemonList);

            if (!trainersCollection.containsKey(trainerName)){
                trainersCollection.put(trainerName, currTrainer);
            } else if (trainersCollection.containsKey(trainerName)){
                trainersCollection.get(trainerName).getPokemonsCollection().add(currPokemont);
            }

            line = reader.readLine();
        }

        line = reader.readLine();
        List<String> elements = new ArrayList<>();
        while (!line.equals("End")){
            String currElement = line;
            elements.add(currElement);
            line = reader.readLine();
        }

        for (String element : elements) {

            boolean containsElement = false;
            for (Map.Entry<String, Trainer> trainer : trainersCollection.entrySet()) {
                List<Pokemon> trainerForPokemontElement = trainer.getValue().getPokemonsCollection();

                for (Pokemon pokemon : trainerForPokemontElement) {
                    String el = pokemon.getElement();

                    if (el.equals(element)){
                        int badges = trainer.getValue().getNumberOfBadges();
                        trainer.getValue().setNumberOfBadges(badges + 1);
                        containsElement = true;
                    }
                }

                if (!containsElement){
                    List<Pokemon> currPokemonColl = trainer.getValue().getPokemonsCollection();
                    for (Pokemon pokemon : currPokemonColl) {
                        int health = pokemon.getHealth() - 10;
                        pokemon.setHealth(health);
                    }
                }
            }
        }

        trainersCollection.entrySet()
                .stream()
                .sorted((b1, b2) -> {
                    int badge1 = b1.getValue().getNumberOfBadges();
                    int badge2 = b2.getValue().getNumberOfBadges();

                    return Integer.compare(badge2, badge1);
                })
                .forEach(tr -> {
                    List<Pokemon> pokemonsList = tr.getValue().getPokemonsCollection();
                    int pokemontCount = 0;
                    for (Pokemon pokemon : pokemonsList) {
                        int pokHealth = pokemon.getHealth();

                        if (pokHealth > 0){
                            pokemontCount++;
                        }
                    }
                    System.out.printf("%s %d %d%n", tr.getKey(), tr.getValue().getNumberOfBadges(), pokemontCount);
                });
    }
}
