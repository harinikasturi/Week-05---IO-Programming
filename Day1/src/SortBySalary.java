import java.io.*;
import java.util.*;

public class SortBySalary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
        List<String[]> records = new ArrayList<>();
        String header = reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            records.add(line.split(","));
        }
        records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));
        System.out.println(header);
        for (int i = 0; i < 5 && i < records.size(); i++) {
            System.out.println(String.join(",", records.get(i)));
        }
        reader.close();
    }
}
