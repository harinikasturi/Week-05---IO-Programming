import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Timer {
    @LogExecutionTime
    public void runProcess() {
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {}
        long end = System.nanoTime();
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}

 class Main7 {
    public static void main(String[] args) {
        new Timer().runProcess();
    }
}
