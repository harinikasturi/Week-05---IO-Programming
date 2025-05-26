import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Developer {
    @BugReport(description = "NullPointerException on line 42")
    @BugReport(description = "IndexOutOfBoundsException in loop")
    public void fixBugs() {}
}

class Main4 {
    public static void main(String[] args) throws Exception {
        Method method = Developer.class.getMethod("fixBugs");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}
