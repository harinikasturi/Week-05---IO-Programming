import java.io.*;
import java.util.Base64;

public class EncryptCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted.csv"));
        String line = reader.readLine(); // header
        writer.write(line + "\n");
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            data[3] = Base64.getEncoder().encodeToString(data[3].getBytes());
            writer.write(String.join(",", data) + "\n");
        }
        reader.close(); writer.close();
    }
}
