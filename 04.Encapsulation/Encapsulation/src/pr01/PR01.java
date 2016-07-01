package pr01;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class PR01 {
    public static void main(String[] args) {

        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        try
       {
           Scanner input = new Scanner(System.in);
           double l = Double.parseDouble(input.nextLine());
           double w = Double.parseDouble(input.nextLine());
           double h = Double.parseDouble(input.nextLine());

           Box box = new Box(l, w, h);

           System.out.printf("Surface Area - %.2f\n", box.surfaceArea());
           System.out.printf("Lateral Surface Area - %.2f\n", box.lateralSurfaceArea());
           System.out.printf("Volume - %.2f\n", box.volume());
       } catch (NumberFormatException nfe){
           System.out.println(nfe.getMessage());
       }

    }
}
