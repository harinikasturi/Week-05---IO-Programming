import java.lang.reflect.Field;
import java.util.*;

public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            } catch (NoSuchFieldException e) {
                System.out.println("No such field: " + entry.getKey());
            }
        }

        return instance;
    }
}

// Example usage
class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

class TestMapper {
    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Alice");
        properties.put("age", 30);

        User user = ObjectMapper.toObject(User.class, properties);
        System.out.println(user);
    }
}