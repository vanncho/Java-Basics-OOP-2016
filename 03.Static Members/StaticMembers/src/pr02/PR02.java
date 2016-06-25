package pr02;

import java.util.HashSet;
import java.util.Scanner;

class Student{
    private String name;

    Student(String name){
        this.name = name;
        StudentGroup.uniqueStudents.add(this.name);
    }
}

class StudentGroup{
    static HashSet<String> uniqueStudents = new HashSet<>();
}

public class PR02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        while (!line.equals("End")){
            Student student = new Student(line);

            line = input.nextLine();
        }

        System.out.println(StudentGroup.uniqueStudents.size());
    }
}
