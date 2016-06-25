package pr12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String occupation;

    Person(String name, int age, String occupation){
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s", this.name, this.age, this.occupation);
    }

    @Override
    public int compareTo(Person o) {

        return Integer.compare(this.age, o.age);
    }
}

public class PR12 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> listOfPersons = new ArrayList<>();

        while (true){
            String[] line = reader.readLine().split("[\\s]+");

            if (line[0].equals("END")){
                break;
            }

            Person currPerson = new Person(line[0], Integer.parseInt(line[1]), line[2]);
            listOfPersons.add(currPerson);
        }

        listOfPersons
                .stream()
                .sorted()
                .forEach(person -> System.out.println(person));
    }
}
