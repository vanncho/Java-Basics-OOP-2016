package pr02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person{
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Family{
    private List<Person> listOfPersons = new ArrayList<>();

    void addMember(Person member){
        this.listOfPersons.add(member);
    }

    public List<Person> getListOfPersons() {
        return listOfPersons;
    }
}

public class PR02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        Family family = new Family();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split("[\\s]+");
            Person currPerson = new Person(tokens[0], Integer.parseInt(tokens[1]));
            family.addMember(currPerson);
        }

        int max = Integer.MIN_VALUE;
        String name = null;
        for (Person pers : family.getListOfPersons()) {

            if (pers.getAge() > max){
                max = pers.getAge();
                name = pers.getName();
            }
        }

        System.out.println(name + " " + max);
    }
}
