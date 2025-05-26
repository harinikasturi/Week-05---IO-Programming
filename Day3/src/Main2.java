import java.util.ArrayList;
import java.util.List;


public class Main2 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        String s = (String) list.get(0);
        System.out.println(s);
    }
}
