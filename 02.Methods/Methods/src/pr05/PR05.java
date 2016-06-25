package pr05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Fibonacci{
    private List<Long> fibonacci;

    Fibonacci(){
        this.fibonacci = new ArrayList<>();
    }

    List<Long> getNumbersInRange(int startPosition, int endPosition){

        List<Long> listToReturn = new ArrayList<>();
        long fibo1 = 0L;
        long fibo2 = 1L;
        long fibonacci = 1L;

        listToReturn.add(fibo1);
        listToReturn.add(fibo2);

        if (startPosition == 1 && endPosition == 2){
            return listToReturn;
        }

        for(int i = 0; i < endPosition; i++){
            fibonacci = fibo1 + fibo2;
            listToReturn.add(fibonacci);
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }

        List<Long> res = new ArrayList<>();
        for (int j = startPosition; j <endPosition; j++) {

                res.add(listToReturn.get(j));


            if (j == endPosition){
                break;
            }
        }

        return res;
    }
}

public class PR05 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        Fibonacci fi = new Fibonacci();
        String toPrint = fi.getNumbersInRange(n, m).toString();
        System.out.println(toPrint.substring(1, toPrint.length() - 1));

    }
}
