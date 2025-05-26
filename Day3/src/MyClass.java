import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class MyClass {
    @ImportantMethod
    public void criticalOperation() {}

    @ImportantMethod(level = "MEDIUM")
    public void moderateOperation() {}
}

class Main5{
    public static void main(String[] args) throws Exception {
        for (Method method : MyClass.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);
                System.out.println(method.getName() + " - Level: " + im.level());
            }
        }
    }
}
