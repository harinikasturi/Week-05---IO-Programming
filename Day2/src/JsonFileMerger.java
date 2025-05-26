import java.nio.file.*;

public class JsonFileMerger {
    public static void main(String[] args) throws Exception {
        String json1 = new String(Files.readAllBytes(Paths.get("file1.json")));
        String json2 = new String(Files.readAllBytes(Paths.get("file2.json")));

        String merged = json1.substring(0, json1.length()-1)
                + ","
                + json2.substring(1);

        Files.write(Paths.get("merged.json"), merged.getBytes());
    }
}