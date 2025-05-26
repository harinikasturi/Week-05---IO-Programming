import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        System.out.println("Default constructor called");
    }

    public Student(String name) {
        this.name = name;
        System.out.println("Parameterized constructor called with name: " + name);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "'}";
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        // Using no-arg constructor
        Class<?> clazz = Class.forName("Student");
        Student student1 = (Student) clazz.newInstance();
        System.out.println(student1);

        // Using parameterized constructor
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Student student2 = (Student) constructor.newInstance("John Doe");
        System.out.println(student2);
    }
}