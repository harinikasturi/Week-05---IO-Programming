import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public double divide(double a, double b) { return a / b; }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MathOperations math = new MathOperations();

        System.out.print("Enter method name (add/subtract/multiply/divide): ");
        String methodName = scanner.next();

        System.out.print("Enter first parameter: ");
        double param1 = scanner.nextDouble();

        System.out.print("Enter second parameter: ");
        double param2 = scanner.nextDouble();

        Class<?> clazz = math.getClass();
        Method method;

        try {
            // Try with int parameters first
            method = clazz.getMethod(methodName, int.class, int.class);
            int result = (int) method.invoke(math, (int)param1, (int)param2);
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            // Fall back to double parameters
            method = clazz.getMethod(methodName, double.class, double.class);
            double result = (double) method.invoke(math, param1, param2);
            System.out.println("Result: " + result);
        }
    }
}