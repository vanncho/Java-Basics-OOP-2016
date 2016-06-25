package pr05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Animal{
    String name;
    String breed;

    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }
}

class AnimalClinic{
    static String patientId;
    static int patientCount;
    static int healedAnimalsCount;
    static int rehabilitedAnimalsCount;
    static List<Animal> healed;
    static List<Animal> rehabilited;

    static {
        patientCount = 0;
        healedAnimalsCount = 0;
        rehabilitedAnimalsCount = 0;
        healed = new ArrayList<>();
        rehabilited = new ArrayList<>();
    }

    static void heal(String name, String breed){
        System.out.printf("Patient %d: [%s (%s)] has been healed!%n", patientCount, name, breed);
    }

    static void rehabilited(String name, String breed){
        System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!%n", patientCount, name, breed);
    }
}

public class PR05 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String line = reader.readLine();

            if (line.equals("End")){
                break;
            }

            String[] animalTokens = line.split("[\\s]+");
            String name = animalTokens[0];
            String breed = animalTokens[1];
            String status = animalTokens[2];

            Animal currAnimal = new Animal(name, breed);
            if (status.equals("heal")){
                AnimalClinic.healedAnimalsCount++;
                AnimalClinic.patientCount++;
                AnimalClinic.healed.add(currAnimal);
                AnimalClinic.heal(name, breed);
            } else {
                AnimalClinic.rehabilitedAnimalsCount++;
                AnimalClinic.patientCount++;
                AnimalClinic.rehabilited.add(currAnimal);
                AnimalClinic.rehabilited(name, breed);
            }
        }

        System.out.printf("Total healed animals: %d%n", AnimalClinic.healed.size());
        System.out.printf("Total rehabilitated animals: %d%n", AnimalClinic.rehabilited.size());

        String command = reader.readLine();

        if (command.equals("heal")){
            List<Animal> healed = AnimalClinic.healed;

            for (Animal animal : healed) {
                System.out.printf("%s %s%n", animal.getName(), animal.getBreed());
            }
        } else {
            List<Animal> healed = AnimalClinic.rehabilited;

            for (Animal animal : healed) {
                System.out.printf("%s %s%n", animal.getName(), animal.getBreed());
            }
        }
    }
}
