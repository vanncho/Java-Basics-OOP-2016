package pr09;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PR09 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaTokens = reader.readLine().split("[\\s]+");
        Pizza pizza = new Pizza(null, 0);

        for (int i = 0; i < pizzaTokens.length; i++) {
            pizza.addPizzaToCollection(pizzaTokens[i]);
        }

        HashMap<Integer, List<String>> pizzaCollection = pizza.addPizzaParameters();

        for (Map.Entry<Integer, List<String>> integerListEntry : pizzaCollection.entrySet()) {
            System.out.printf("%d - %s%n", integerListEntry.getKey(), integerListEntry.getValue().toString().substring(1, integerListEntry.getValue().toString().length() - 1));
        }

        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }


    }
}
