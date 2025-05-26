import java.nio.file.*;
import java.util.regex.*;

public class AgeFilter {
    public static void main(String[] args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("people.json")));

        // Pattern to match each person object
        Pattern personPattern = Pattern.compile("\\{(.*?)\\}");
        Matcher personMatcher = personPattern.matcher(json);

        while (personMatcher.find()) {
            String person = personMatcher.group(1);
            Pattern agePattern = Pattern.compile("\"age\"\\s*:\\s*(\\d+)");
            Matcher ageMatcher = agePattern.matcher(person);

            if (ageMatcher.find()) {
                int age = Integer.parseInt(ageMatcher.group(1));
                if (age > 25) {
                    System.out.println("{" + person + "}");
                }
            }
        }
    }
}