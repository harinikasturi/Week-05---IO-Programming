import java.nio.file.*;

public class JsonValidator {
    public static void main(String[] args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("data.json")));

        // Basic validation - check balanced braces
        long openBraces = json.chars().filter(ch -> ch == '{').count();
        long closeBraces = json.chars().filter(ch -> ch == '}').count();

        if (openBraces == closeBraces) {
            System.out.println("Valid JSON structure");
        } else {
            System.out.println("Invalid JSON structure");
        }
    }
}