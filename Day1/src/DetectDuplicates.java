import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("students.csv"));
        Set<String> ids = new HashSet<>();
        String line = reader.readLine(); // header
        while ((line = reader.readLine()) != null) {
            String id = line.split(",")[0];
            if (!ids.add(id)) {
                System.out.println("Duplicate: " + line);
            }
        }
        reader.close();
    }
}
