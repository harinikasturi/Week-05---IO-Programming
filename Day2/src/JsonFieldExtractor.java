import java.nio.file.*;
import java.util.regex.*;

public class JsonFieldExtractor {
    public static void main(String[] args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("data.json")));

        Pattern namePattern = Pattern.compile("\"name\"\\s*:\\s*\"([^\"]*)\"");
        Pattern emailPattern = Pattern.compile("\"email\"\\s*:\\s*\"([^\"]*)\"");

        Matcher nameMatcher = namePattern.matcher(json);
        Matcher emailMatcher = emailPattern.matcher(json);

        while (nameMatcher.find() && emailMatcher.find()) {
            System.out.println("Name: " + nameMatcher.group(1));
            System.out.println("Email: " + emailMatcher.group(1));
        }
    }
}