import java.lang.reflect.Field;
import java.util.*;

public class JsonGenerator {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\":");

            Object value = fields[i].get(obj);
            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            if (i < fields.length - 1) {
                json.append(",");
            }
        }

        json.append("}");
        return json.toString();
    }
}

// Example usage
class Product {
    private String name = "Laptop";
    private double price = 999.99;
    private int stock = 10;
}

class TestJsonGenerator {
    public static void main(String[] args) throws Exception {
        Product product = new Product();
        System.out.println(JsonGenerator.toJson(product));
    }
}