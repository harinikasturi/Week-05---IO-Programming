import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("contacts.csv"));
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");
        String line = reader.readLine(); // header
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (!emailPattern.matcher(data[1]).matches()) {
                System.out.println("Invalid Email: " + line);
            }
            if (!phonePattern.matcher(data[2]).matches()) {
                System.out.println("Invalid Phone: " + line);
            }
        }
        reader.close();
    }
}
