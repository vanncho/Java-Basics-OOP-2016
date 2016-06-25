package pr10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Person {
    protected String firstName;
    protected String lastName;
    protected String birthdate;
    protected List<Person> parents;
    protected List<Person> children;

    Person(String firstName, String lastName, String birthdate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    Person(String firsName, String lastName) {
        this(firsName, lastName, null);
    }

    Person(String birthday) {
        this(null, null, birthday);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s %s %s%n", this.firstName, this.lastName, this.birthdate));
        output.append(String.format("Parents:%n"));
        for (Person parent : parents) {
            output.append(String.format("%s %s %s%n", parent.firstName, parent.lastName, parent.birthdate));
        }
        output.append(String.format("Children:%n"));
        for (Person child : children) {
            output.append(String.format("%s %s %s%n", child.firstName, child.lastName, child.birthdate));
        }
        return output.toString();
    }
}

public class PR10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Person> peopleWithNames = new HashMap<>();
        HashMap<String, Person> peopleWithBirthday = new HashMap<>();

        List<Person> familyTree = new ArrayList<>();
        String input = reader.readLine().trim();
        boolean isName = false;
        if (input.contains(" ")) {
            isName = true;
        }

        while (true) {
            String line = reader.readLine();
            if (line.equals("End")) {
                break;
            }

            String[] tokens = line.split(" - ");
            if (tokens.length == 2) {
                Person parent = null;
                Person child = null;
                if (tokens[0].contains(" ")) {
                    if (peopleWithNames.containsKey(tokens[0])) {
                        parent = peopleWithNames.get(tokens[0]);
                    } else {
                        parent = null;
                    }
                } else {
                    if (peopleWithBirthday.containsKey(tokens[0])) {
                        parent = peopleWithBirthday.get(tokens[0]);
                    } else {
                        parent = null;
                    }
                }
                if (tokens[1].contains(" ")) {
                    if (peopleWithNames.containsKey(tokens[1])) {
                        child = peopleWithNames.get(tokens[1]);
                    } else {
                        child = null;
                    }
                } else {
                    if (peopleWithBirthday.containsKey(tokens[1])) {
                        child = peopleWithBirthday.get(tokens[1]);
                    } else {
                        child = null;
                    }
                }

                if (parent == null) {
                    if (tokens[0].contains(" ")) {
                        String[] parentName = tokens[0].split("\\s+");
                        parent = new Person(parentName[0], parentName[1]);
                        peopleWithNames.put(tokens[0], parent);
                    } else {
                        parent = new Person(tokens[0]);
                        peopleWithBirthday.put(tokens[0], parent);
                    }
                    familyTree.add(parent);
                }
                if (child == null) {
                    if (tokens[1].contains(" ")) {
                        String[] childNames = tokens[1].split("\\s+");
                        child = new Person(childNames[0], childNames[1]);
                        peopleWithNames.put(tokens[1], child);
                    } else {
                        child = new Person(tokens[1]);
                        peopleWithBirthday.put(tokens[1], child);
                    }
                    familyTree.add(child);
                }
                parent.children.add(child);
                child.parents.add(parent);

            } else if (tokens.length == 1) {

                String[] tokensTwo = tokens[0].split("\\s+");

                Person personWithName = null;
                String fullName = String.format("%s %s", tokensTwo[0], tokensTwo[1]);
                if (peopleWithNames.containsKey(fullName)){
                    personWithName = peopleWithNames.get(fullName);
                }

                Person personWithBirthdate = null;
                if (peopleWithBirthday.containsKey(tokensTwo[2])){
                    personWithBirthdate = peopleWithBirthday.get(tokensTwo[2]);
                }

                if (personWithName != null && personWithBirthdate != null) {
                    int indexPersonName = familyTree.indexOf(personWithName);
                    int indexPersonBirthdate = familyTree.indexOf(personWithBirthdate);

                    if (indexPersonName < indexPersonBirthdate) {

                        personWithName.birthdate = personWithBirthdate.birthdate;
                        for (Person parent : personWithBirthdate.parents) {
                            parent.children.remove(personWithBirthdate);
                            parent.children.add(personWithName);
                            personWithName.parents.add(parent);
                        }
                        for (Person child : personWithBirthdate.children) {
                            child.parents.remove(personWithBirthdate);
                            child.parents.add(personWithName);
                            personWithName.children.add(child);
                        }
                    } else {
                        personWithBirthdate.firstName = personWithName.firstName;
                        personWithBirthdate.lastName = personWithName.lastName;
                        for (Person parent : personWithName.parents) {
                            parent.children.remove(personWithName);
                            parent.children.add(personWithBirthdate);
                            personWithBirthdate.parents.add(parent);
                        }
                        for (Person child : personWithName.children) {
                            child.parents.remove(personWithName);
                            child.parents.add(personWithBirthdate);
                            personWithBirthdate.children.add(child);
                        }
                    }
                } else if (personWithBirthdate != null) {

                    personWithBirthdate.firstName = tokensTwo[0];
                    personWithBirthdate.lastName = tokensTwo[1];
                    peopleWithNames.put(fullName, personWithBirthdate);
                } else if (personWithName != null) {

                    personWithName.birthdate = tokensTwo[2];
                    peopleWithBirthday.put(tokensTwo[2], personWithName);
                } else {

                    Person newPerson = new Person(tokensTwo[0], tokensTwo[1], tokensTwo[2]);
                    peopleWithBirthday.put(tokensTwo[2], newPerson);
                    peopleWithNames.put(fullName, newPerson);
                    familyTree.add(newPerson);
                }
            }
        }

        if (isName) {
            String[] name = input.split("\\s+");
            final String fName = name[0];
            final String lName = name[1];
            Person searched = familyTree.stream()
                    .filter(n -> n.firstName.equals(fName) && n.lastName.equals(lName))
                    .findFirst().get();
            System.out.print(searched);
        } else {
            final String bDay = input;
            Person searched = familyTree.stream()
                    .filter(b -> b.birthdate.equals(bDay))
                    .findFirst().get();
            System.out.print(searched);
        }
    }
}