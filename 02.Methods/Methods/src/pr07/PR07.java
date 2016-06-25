package pr07;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PR07 {
    public static void main(String[] args) {

        Field[] fields = ImmutableList.class.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatException();
        } else {
            System.out.println(fields.length);
        }

        Method[] methods = ImmutableList.class.getDeclaredMethods();
        List<Method> methodsReturnTypes = Arrays.stream(methods).filter(m -> {
            if (!m.getReturnType().getName().equalsIgnoreCase("ImmutableList")) {
                return false;
            }

            return true;
        }).collect(Collectors.toList());

        if (methodsReturnTypes.size() < 1) {
            throw new ClassFormatException();
        }
        System.out.println(5);
    }
}
