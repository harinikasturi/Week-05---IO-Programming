import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username, int i) throws Exception {
        this.username = username;
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                field.setAccessible(true);
                MaxLength ml = field.getAnnotation(MaxLength.class);
                String value = (String) field.get(this);
                if (value.length() > ml.value()) {
                    throw new IllegalArgumentException("Field " + field.getName() + " exceeds max length");
                }
            }
        }
    }


}

class Main8{
    public static void main(String[] args) throws Exception {
        new User("Harini123", 23);  // OK
        new User("HariniKasturiLongName", 23);  // Throws Exception
    }
}
