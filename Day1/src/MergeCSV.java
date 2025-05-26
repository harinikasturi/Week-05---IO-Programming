import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws IOException {
        Map<String, String[]> map1 = new HashMap<>();
        BufferedReader r1 = new BufferedReader(new FileReader("students1.csv"));
        BufferedReader r2 = new BufferedReader(new FileReader("students2.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("merged.csv"));

        r1.readLine(); r2.readLine(); // skip headers
        String line;
        while ((line = r1.readLine()) != null) {
            String[] data = line.split(",");
            map1.put(data[0], data);
        }
        writer.write("ID,Name,Age,Marks,Grade\n");
        while ((line = r2.readLine()) != null) {
            String[] data2 = line.split(",");
            String[] data1 = map1.get(data2[0]);
            if (data1 != null) {
                writer.write(String.join(",", data1[0], data1[1], data1[2], data2[1], data2[2]) + "\n");
            }
        }
        r1.close(); r2.close(); writer.close();
    }
}
