package pr02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person{
    static final String DEFAULT_NAME = "No name";

    String name;
    int age;

    Person() {
        this(DEFAULT_NAME, 1);
    }

    Person(int age) {
        this(DEFAULT_NAME, age);
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class pr02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split("[\\s]+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person currPerson = new Person(name, age);
            persons.add(currPerson);
        }

        persons.stream()
                .filter(age -> age.age > 30)
                .sorted((name1, name2) -> name1.name.compareTo(name2.name))
                .forEach(person -> System.out.println(person.name + " - " + person.age));

    }
}
