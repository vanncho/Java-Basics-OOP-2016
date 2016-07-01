package pr06;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);

            while (true) {
                String line = input.nextLine();

                if (line.equals("Beast!")) {
                    break;
                }

                String[] animalTokens = null;
                String name = null;
                int age = 0;
                String gender = null;
                Animal animal = null;

                switch (line) {
                    case "Dog":
                        animalTokens = input.nextLine().split("[\\s]+");
                        name = animalTokens[0];
                        age = Integer.valueOf(animalTokens[1]);
                        gender = animalTokens[2];

                        animal = new Dog(name, age, gender);

                        break;
                    case "Cat":
                        animalTokens = input.nextLine().split("[\\s]+");
                        name = animalTokens[0];
                        age = Integer.valueOf(animalTokens[1]);
                        gender = animalTokens[2];

                        animal = new Cat(name, age, gender);
                        break;
                    case "Frog":
                        animalTokens = input.nextLine().split("[\\s]+");
                        name = animalTokens[0];
                        age = Integer.valueOf(animalTokens[1]);
                        gender = animalTokens[2];

                        animal = new Frog(name, age, gender);
                        break;
                    case "Kitten":
                        animalTokens = input.nextLine().split("[\\s]+");
                        name = animalTokens[0];
                        age = Integer.valueOf(animalTokens[1]);

                        animal = new Kitten(name, age);
                        break;
                    case "Tomcat":
                        animalTokens = input.nextLine().split("[\\s]+");
                        name = animalTokens[0];
                        age = Integer.valueOf(animalTokens[1]);

                        animal = new Tomcat(name, age);
                        break;
                    case "Animal":
                        animalTokens = input.nextLine().split("[\\s]+");
                        name = animalTokens[0];
                        age = Integer.valueOf(animalTokens[1]);
                        gender = animalTokens[2];

                        animal = new Animal(name, age, gender);
                        break;
                }

                if (animal != null){
                    System.out.println(animal.getClass().getSimpleName());
                    System.out.println(animal);
                    System.out.println(animal.produceSound());
                }
            }
        }  catch (IllegalArgumentException iae){
        System.out.println(iae.getMessage());
      }
    }
}
