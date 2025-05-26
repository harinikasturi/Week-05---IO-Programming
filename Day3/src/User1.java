import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User1 {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User1(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String toJson() throws Exception {
        Map<String, Object> jsonMap = new HashMap<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jf = field.getAnnotation(JsonField.class);
                jsonMap.put(jf.name(), field.get(this));
            }
        }
        return jsonMap.toString();
    }
}

class Main10 {
    public static void main(String[] args) throws Exception {
        User u = new User("Harini", 23);
        System.out.println(u.toString());
    }
}
