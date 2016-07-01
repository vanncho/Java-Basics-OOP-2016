package pr03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Human{
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        String regex = "(?=^)[A-Za-z0-9]{5,10}(?=$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(facultyNumber);

        if(!matcher.find()){
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s%n", this.getFirstName()));
        sb.append(String.format("Last Name: %s%n", this.getLastName()));
        sb.append(String.format("Faculty number: %s", this.getFacultyNumber()));
        return sb.toString();
    }
}
