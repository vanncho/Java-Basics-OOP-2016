package pr09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Person {
    private String name;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;
    private Company company;
    private Car car;

    Person(String name, List<Parents> parents, List<Children> children, List<Pokemon> pokemons, Company company, Car car){
        this.name = name;
        this.parents = parents;
        this.children = children;
        this.pokemons = pokemons;
        this.company = company;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parents=" + parents +
                ", children=" + children +
                ", pokemons=" + pokemons +
                ", company=" + company +
                ", car=" + car +
                '}';
    }
}

class Pokemon {
    private String name;
    private String type;

    Pokemon(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class Parents {
    String name;
    String birthday;

    Parents(String name, String birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Parents{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

class Children {
    String name;
    String birthday;

    Children(String name, String birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

class Company {
    private String name;
    private String department;
    private double salary;

    Company(String name, String department, double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Car {
    private String model;
    private int speed;

    Car(String model, int speed){
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}

public class PR09 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> personData = new HashMap<>();

        String line = reader.readLine();
        while (!line.equals("End")){
            String[] tokens = line.split("[\\s]+");
            String name = tokens[0];
            String categoryData = tokens[1];

            Company currCompany = new Company("", "", 0d);
            Pokemon currPokemon = new Pokemon("", "");
            Parents currParent = new Parents("", "");
            Children currChild = new Children("", "");
            Car currCar = new Car("", 0);
            Person currPerson = new Person(null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), currCompany, currCar);

            if (!personData.containsKey(name)){
                personData.put(name, currPerson);
            }

            switch (categoryData){
                case "company":
                    currCompany.setName(tokens[2]);
                    currCompany.setDepartment(tokens[3]);
                    currCompany.setSalary(Double.parseDouble(tokens[4]));
                    personData.get(name).setCompany(currCompany);
                    break;
                case "pokemon":
                    currPokemon.setName(tokens[2]);
                    currPokemon.setType(tokens[3]);
                    personData.get(name).getPokemons().add(currPokemon);
                    break;
                case "parents":
                    currParent.setName(tokens[2]);
                    currParent.setBirthday(tokens[3]);
                    personData.get(name).getParents().add(currParent);
                    break;
                case "children":
                    currChild.setName(tokens[2]);
                    currChild.setBirthday(tokens[3]);
                    personData.get(name).getChildren().add(currChild);
                    break;
                case "car":
                    currCar.setModel(tokens[2]);
                    currCar.setSpeed(Integer.parseInt(tokens[3]));
                    personData.get(name).setCar(currCar);
                    break;
            }

            line = reader.readLine();
        }

        String nameToPrint = reader.readLine();

        System.out.println(nameToPrint);
        System.out.println("Company:");
        if (!personData.get(nameToPrint).getCompany().getName().equals("")){
            System.out.printf("%s %s %.2f%n", personData.get(nameToPrint).getCompany().getName(), personData.get(nameToPrint).getCompany().getDepartment(), personData.get(nameToPrint).getCompany().getSalary());
        }
        System.out.println("Car:");
        if (!personData.get(nameToPrint).getCar().getModel().equals("")){
            System.out.printf("%s %d%n", personData.get(nameToPrint).getCar().getModel(), personData.get(nameToPrint).getCar().getSpeed());
        }
        System.out.println("Pokemon:");
        for (Pokemon pokemon : personData.get(nameToPrint).getPokemons()) {
            System.out.printf("%s %s%n", pokemon.getName(), pokemon.getType());
        }
        System.out.println("Parents:");
        for (Parents parent : personData.get(nameToPrint).getParents()) {
            System.out.printf("%s %s%n", parent.getName(), parent.getBirthday());
        }
        System.out.println("Children:");
        for (Children child : personData.get(nameToPrint).getChildren()) {
            System.out.printf("%s %s%n", child.getName(), child.getBirthday());
        }

    }
}
