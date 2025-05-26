import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "initial_key";
}

public class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Configuration.class;
        Field apiKeyField = clazz.getDeclaredField("API_KEY");

        apiKeyField.setAccessible(true);

        System.out.println("Original API_KEY: " + apiKeyField.get(null));

        apiKeyField.set(null, "new_key");
        System.out.println("Modified API_KEY: " + apiKeyField.get(null));
    }
}