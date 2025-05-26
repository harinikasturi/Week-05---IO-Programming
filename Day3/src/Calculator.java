import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class Calculator {
    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveCalculation(int input) {
        if (cache.containsKey(input)) {
            System.out.println("Returning cached result");
            return cache.get(input);
        }
        int result = input * input; // Simulate expensive work
        cache.put(input, result);
        return result;
    }
}

class Main11 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.expensiveCalculation(5));
        System.out.println(c.expensiveCalculation(5)); // Should return cached
    }
}
