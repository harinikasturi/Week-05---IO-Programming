import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class DatabaseService {
    public void connect() {
        System.out.println("Connected to database");
    }
}

class UserService {
    @Inject
    private DatabaseService databaseService;

    public void performTask() {
        databaseService.connect();
        System.out.println("Performing user task");
    }
}

class DIContainer {
    public static void injectDependencies(Object target) throws Exception {
        Class<?> clazz = target.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().newInstance();
                field.set(target, dependency);
            }
        }
    }
}

class TestDI {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
        DIContainer.injectDependencies(userService);
        userService.performTask();
    }
}