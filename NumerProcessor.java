import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

interface Calculator {
    int calculate(int a, int b);
}

class Printer {
    void print(String s) {
        System.out.println(s);
    }
}

class MathUtils {
    static int square(int n) {
        return n * n;
    }
}

public class NumerProcessor {
    static void printNumber(int n) {
        System.out.println(n);
    }

    static int operate(int a, int b, Calculator operation) {
        return operation.calculate(a, b);
    }

    static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
         List<Integer> numbers = Arrays.asList(10,20,30,40,50);
        List<String> names = Arrays.asList("Aditya", "Rahul", "Aman");
        // numbers.forEach(n-> printNumber(n));
        // numbers.forEach(NumerProcessor :: printNumber);

         names.forEach(n->print(n));
        // names.forEach(NumerProcessor :: print);

        // Printer printer = new Printer();
        // names.forEach(n->printer.print(n));
        // names.forEach(printer :: print);
         Function<Integer,Integer> func = MathUtils :: square;
         numbers.forEach(n->func.apply(n));

        // task : 1
        Calculator subtraction = (a, b) -> (a - b);
        System.out.println(subtraction.calculate(10, 4));

        // task : 2
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-10));

        // task 3
        Function<String, Integer> getLength = n -> n.length();
        System.out.println(getLength.apply("JAVA IS A CUP OF WHAT?"));

        //task 4
        Consumer<String> printUpper = n -> System.out.println(n.toUpperCase());
        printUpper.accept("i dont know what string to give");
        
        // task 5
        Calculator multiply = (a,b)->a*b;
        int result = operate(10,5,multiply);
        System.out.println(result);

    }
}
