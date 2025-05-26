import java.nio.file.*;
import java.util.*;

public class CsvToJson {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("data.csv"));
        if (lines.isEmpty()) return;

        String[] headers = lines.get(0).split(",");
        StringBuilder jsonArray = new StringBuilder("[");

        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            StringBuilder jsonObj = new StringBuilder("{");

            for (int j = 0; j < headers.length && j < values.length; j++) {
                if (j > 0) jsonObj.append(",");
                jsonObj.append("\"").append(headers[j].trim()).append("\":")
                        .append(values[j].trim().matches("\\d+") ?
                                values[j].trim() :
                                "\"" + values[j].trim() + "\"");
            }
            jsonObj.append("}");

            if (i > 1) jsonArray.append(",");
            jsonArray.append(jsonObj);
        }
        jsonArray.append("]");

        System.out.println(jsonArray.toString());
    }
}