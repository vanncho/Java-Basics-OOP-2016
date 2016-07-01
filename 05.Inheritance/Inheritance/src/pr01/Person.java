package pr01;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public void setName(String name) {

        if (name == null || name.length() < 3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }

        this.name = name;
    }

    public void setAge(int age) {

        if (age < 1){
            throw new IllegalArgumentException("Age must be positive!");
        }

        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %s", this.getName(), this.getAge()));

        return sb.toString();
    }
}
