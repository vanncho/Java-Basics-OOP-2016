package pr01;

import java.util.Scanner;

class Person {
    private String name;

    Person (String name){
        this.name = name;
    }

    void printGreeting(){
        System.out.printf("%s says \"Hello\"!", this.name);
    }
}

public class PR01 {
    public static void main(String[] args) throws ClassNotFoundException {

        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        Person person = new Person(name);
        person.printGreeting();
    }
}
