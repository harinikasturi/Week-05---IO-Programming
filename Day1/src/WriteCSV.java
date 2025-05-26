import java.io.*;

public class WriteCSV {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("employees.csv"));
        writer.write("ID,Name,Department,Salary\n");
        writer.write("1,John,IT,50000\n2,Alice,HR,45000\n3,Mark,Sales,55000\n4,Sara,IT,60000\n5,Tom,Finance,48000\n");
        writer.close();
    }
}
