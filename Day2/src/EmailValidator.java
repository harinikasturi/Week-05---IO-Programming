import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        String json = "{\"email\":\"test@example.com\"}";

        Pattern emailPattern = Pattern.compile("\"email\"\\s*:\\s*\"([^\"]*)\"");
        Matcher emailMatcher = emailPattern.matcher(json);

        if (emailMatcher.find()) {
            String email = emailMatcher.group(1);
            boolean isValid = email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
            System.out.println("Email is " + (isValid ? "valid" : "invalid"));
        }
    }
}