import java.io.*;

public class SearchEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
        String searchName = "Sara";
        String line = reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equalsIgnoreCase(searchName)) {
                System.out.printf("Department: %s, Salary: %s%n", data[2], data[3]);
            }
        }
        reader.close();
    }
}
