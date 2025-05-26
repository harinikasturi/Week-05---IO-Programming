import java.io.*;

public class FilterMarks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("students.csv"));
        String line = reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[3]) > 80) {
                System.out.println(line);
            }
        }
        reader.close();
    }
}
