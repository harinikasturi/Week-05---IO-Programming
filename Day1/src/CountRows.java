import java.io.*;

public class CountRows {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
        int count = 0;
        reader.readLine(); // skip header
        while (reader.readLine() != null) count++;
        reader.close();
        System.out.println("Total records: " + count);
    }
}
