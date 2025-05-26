import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class FeatureDev {
    @Todo(task = "Add login", assignedTo = "Harini")
    public void loginFeature() {}

    @Todo(task = "Create dashboard", assignedTo = "Alex", priority = "HIGH")
    public void dashboardFeature() {}
}

class Main6 {
    public static void main(String[] args) {
        for (Method method : FeatureDev.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println(method.getName() + ": " + todo.task() +
                        ", Assigned to: " + todo.assignedTo() +
                        ", Priority: " + todo.priority());
            }
        }
    }
}
