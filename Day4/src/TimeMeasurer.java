import java.lang.reflect.*;

class TimeMeasurer {
    public static void measureExecutionTime(Object target) throws Exception {
        Class<?> clazz = target.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getParameterCount() == 0 && method.getReturnType() == void.class) {
                long startTime = System.nanoTime();
                method.invoke(target);
                long endTime = System.nanoTime();

                System.out.println("Method " + method.getName() +
                        " executed in " + (endTime - startTime) + " ns");
            }
        }
    }
}

class TestClass {
    public void fastMethod() {
        // Some fast operation
    }

    public void slowMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestTiming {
    public static void main(String[] args) throws Exception {
        TestClass testObj = new TestClass();
        TimeMeasurer.measureExecutionTime(testObj);
    }
}