package pr01;

import java.util.Scanner;

class Student{
    private String name;
    static int number = 0;

    Student (){
    }
}

public class PR01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        while (!line.equals("End")){
            Student currStudent = new Student();
            Student.number++;

            line = input.nextLine();
        }

        System.out.println(Student.number);
    }
}
