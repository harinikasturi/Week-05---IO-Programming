import java.sql.*;
import java.util.*;

public class DatabaseToJson {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:sample.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();
            List<String> jsonObjects = new ArrayList<>();

            while (rs.next()) {
                StringBuilder json = new StringBuilder("{");
                for (int i = 1; i <= colCount; i++) {
                    if (i > 1) json.append(",");
                    json.append("\"").append(meta.getColumnName(i)).append("\":");

                    Object value = rs.getObject(i);
                    if (value instanceof Number) {
                        json.append(value);
                    } else {
                        json.append("\"").append(value).append("\"");
                    }
                }
                json.append("}");
                jsonObjects.add(json.toString());
            }

            String jsonReport = "[" + String.join(",", jsonObjects) + "]";
            System.out.println(jsonReport);
        }
    }
}