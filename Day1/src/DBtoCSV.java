// Requires JDBC setup
import java.io.*;
import java.sql.*;

public class DBtoCSV {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "user", "pass");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");
        BufferedWriter writer = new BufferedWriter(new FileWriter("fromdb.csv"));
        writer.write("ID,Name,Department,Salary\n");
        while (rs.next()) {
            writer.write(String.format("%d,%s,%s,%.2f\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
        }
        writer.close(); rs.close(); stmt.close(); conn.close();
    }
}
