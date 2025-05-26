import java.nio.file.*;
import java.util.regex.*;

public class JsonKeyValuePrinter {
    public static void main(String[] args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("data.json")));

        Pattern kvPattern = Pattern.compile("\"(.*?)\"\\s*:\\s*(\".*?\"|\\d+)");
        Matcher kvMatcher = kvPattern.matcher(json);

        while (kvMatcher.find()) {
            System.out.println("Key: " + kvMatcher.group(1)
                    + ", Value: " + kvMatcher.group(2));
        }
    }
}