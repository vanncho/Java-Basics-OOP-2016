package pr03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PR03 {
    public static void main(String[] args) throws IOException {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] studentTokens = reader.readLine().split("[\\s]+");
            String[] workerTokens = reader.readLine().split("[\\s]+");

            Student student = new Student(studentTokens[0], studentTokens[1], studentTokens[2]);
            Worker worker = new Worker(workerTokens[0], workerTokens[1], Double.valueOf(workerTokens[2]), Double.valueOf(workerTokens[3]));

            System.out.println(student);
            System.out.println();
            System.out.println(worker);

        }catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}