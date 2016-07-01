package pr03;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {

        char firstLetter = firstName.charAt(0);
        if (firstLetter < 65 || firstLetter > 90) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }

        if (firstName.trim().length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = firstName;
    }

    private void setLastName(String lastName) {

        char firstLetter = lastName.charAt(0);
        if (firstLetter < 65 || firstLetter > 90) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }

        if (lastName.trim().length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
