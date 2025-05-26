import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\OneDrive\\Desktop\\Capgemini\\Week-05---IO-Programming\\src\\Students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            br.readLine();

            // Read and print each line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Assuming the CSV structure is: ID, Name, Age, Marks
                String id = values[0];
                String name = values[1];
                String age = values[2];
                String marks = values[3];

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
