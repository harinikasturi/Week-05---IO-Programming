
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterUsersByAge {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("users.json")));
        JSONArray users = new JSONArray(content);

        System.out.println("Users older than 25:");
        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            if (user.getInt("age") > 25) {
                System.out.println("- " + user.getString("name") +
                        " (" + user.getInt("age") + ")");
            }
        }
    }
}