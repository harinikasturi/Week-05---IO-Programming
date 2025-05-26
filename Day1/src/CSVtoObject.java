import java.io.*;
import java.util.*;

class Student {
    String id, name;
    int age;
    double marks;

    Student(String[] data) {
        id = data[0]; name = data[1]; age = Integer.parseInt(data[2]); marks = Double.parseDouble(data[3]);
    }

    public String toString() {
        return id + " " + name + " " + age + " " + marks;
    }
}

public class CSVtoObject {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("students.csv"));
        List<Student> students = new ArrayList<>();
        reader.readLine(); // skip header
        String line;
        while ((line = reader.readLine()) != null) {
            students.add(new Student(line.split(",")));
        }
        students.forEach(System.out::println);
        reader.close();
    }
}
