package pr04;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    Employee(String name, double salary, String position, String department, String email, int age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    //public Employee(String name, double salary, String position, String department) {
    //    this(name, salary, position, department, "n/a", -1);
    //}
}

public class PR04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        HashMap<String, Double> depAndSalary = new HashMap<>();
        HashMap<String, List<Employee>> employeesData = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split("[\\s]+");
            String emplName = tokens[0];
            double emplSalary = Double.parseDouble(tokens[1]);
            String emplPosition = tokens[2];
            String emplDepartment = tokens[3];
            String emplMail = "n/a";
            int emplAge = -1;
            Employee currEmployee = null;

            switch (tokens.length){
                case 4:
                    currEmployee = new Employee(emplName, emplSalary, emplPosition, emplDepartment, emplMail, emplAge);
                    break;
                case 5:
                    if (tokens[4].indexOf("@") < 0){
                        emplAge = Integer.parseInt(tokens[4]);
                        currEmployee = new Employee(emplName, emplSalary, emplPosition, emplDepartment, emplMail, emplAge);
                    } else {
                        emplMail = tokens[4];
                        currEmployee = new Employee(emplName, emplSalary, emplPosition, emplDepartment, emplMail, emplAge);
                    }
                    break;
                case 6:
                    emplMail = tokens[4];
                    emplAge = Integer.parseInt(tokens[5]);
                    currEmployee = new Employee(emplName, emplSalary, emplPosition, emplDepartment, emplMail, emplAge);
                    break;
            }

            if (!depAndSalary.containsKey(emplDepartment)){
                depAndSalary.put(emplDepartment, 0d);

                employeesData.put(emplDepartment, new ArrayList<>());
            }

            double totalSalaries = depAndSalary.get(emplDepartment) + emplSalary;
            depAndSalary.put(emplDepartment, totalSalaries);
            employeesData.get(emplDepartment).add(currEmployee);
        }

        LinkedHashMap<String, Double> sortedByDepatment = depAndSalary.entrySet()
                .stream()
                .sorted((s1, s2) -> Double.compare(s2.getValue(), s1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap<String, Double>::new));

        for (String s : sortedByDepatment.keySet()) {
            System.out.printf("Highest Average Salary: %s%n", s);

            List<Employee> output = employeesData.get(s);

            output.stream()
                    .sorted((x, y) -> Double.compare(y.salary, x.salary))
                    .forEach(employee ->
                            System.out.printf("%s %.2f %s %d%n", employee.name, employee.salary, employee.email, employee.age));
            break;
        }
    }
}
