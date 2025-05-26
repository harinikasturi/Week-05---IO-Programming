public class JsonMerger {
    public static void main(String[] args) {
        String json1 = "{\"name\":\"Alice\",\"age\":25}";
        String json2 = "{\"city\":\"Mumbai\",\"country\":\"India\"}";

        // Remove closing brace from first JSON
        String merged = json1.substring(0, json1.length()-1)
                + ","
                + json2.substring(1);
        System.out.println(merged);
    }
}