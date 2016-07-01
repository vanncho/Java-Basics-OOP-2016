package pr03;

public class Worker extends Human{
    public static final int WORK_DAYS = 7;
    private double weekSalary;
    private double workHours;

    public Worker(String firstName, String lastName, double weekSalary, double workHours) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHours(workHours);
    }

    private void setWeekSalary(double weekSalary) {

        if (weekSalary < 10){
            throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
        }

        this.weekSalary = weekSalary;
    }

    private void setWorkHours(double workHours) {

        if (workHours < 1 || workHours > 12){
            throw new IllegalArgumentException("Expected value mismatch! Argument: workHoursPerDay");
        }

        this.workHours = workHours;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public double getWorkHours() {
        return workHours;
    }

    private double getSalaryPerHour(){
        return this.weekSalary / (WORK_DAYS * this.workHours);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s%n", this.getFirstName()));
        sb.append(String.format("Last Name: %s%n", this.getLastName()));
        sb.append(String.format("Week Salary: %.2f%n", this.getWeekSalary()));
        sb.append(String.format("Hours per day: %.2f%n", this.getWorkHours()));
        sb.append(String.format("Salary per hour: %.2f", this.getSalaryPerHour()));
        return sb.toString();
    }
}
