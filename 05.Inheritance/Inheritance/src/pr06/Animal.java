package pr06;

public class Animal implements Sound {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {

        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    private void setAge(int age) {

        if (age <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    private void setGender(String gender) {

        if (gender == null || gender.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.gender);
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }
}
