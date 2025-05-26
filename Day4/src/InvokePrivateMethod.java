import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        Class<?> clazz = calculator.getClass();

        Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);

        int result = (int) multiplyMethod.invoke(calculator, 5, 7);
        System.out.println("Result: " + result);
    }
}