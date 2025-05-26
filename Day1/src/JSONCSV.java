import org.json.*;
import java.io.*;

public class JSONCSV {
    public static void jsonToCsv(String jsonFile, String csvFile) throws IOException {
        String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(jsonFile)));
        JSONArray array = new JSONArray(content);
        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
        JSONObject obj = array.getJSONObject(0);
        writer.write(String.join(",", obj.keySet()) + "\n");
        for (Object o : array) {
            JSONObject jo = (JSONObject) o;
            writer.write(String.join(",", jo.toMap().values().stream().map(String::valueOf).toArray(String[]::new)) + "\n");
        }
        writer.close();
    }

    public static void csvToJson(String csvFile, String jsonFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String[] headers = reader.readLine().split(",");
        JSONArray array = new JSONArray();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            JSONObject obj = new JSONObject();
            for (int i = 0; i < headers.length; i++) obj.put(headers[i], data[i]);
            array.put(obj);
        }
        reader.close();
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(array.toString(2));
        writer.close();
    }
}
