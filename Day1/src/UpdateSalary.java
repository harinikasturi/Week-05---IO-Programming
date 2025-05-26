import java.io.*;
import java.util.*;

public class UpdateSalary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("updated_employees.csv"));
        String line = reader.readLine();
        writer.write(line + "\n");
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data[2].equalsIgnoreCase("IT")) {
                double salary = Double.parseDouble(data[3]) * 1.10;
                data[3] = String.format("%.2f", salary);
            }
            writer.write(String.join(",", data) + "\n");
        }
        reader.close();
        writer.close();
    }
}
