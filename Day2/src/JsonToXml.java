public class JsonToXml {
    public static void main(String[] args) {
        String json = "{\"person\":{\"name\":\"Alice\",\"age\":30}}";

        // Simple conversion - for complex JSON you'd need a proper parser
        String xml = json.replaceAll("\"([^\"]*)\"\\s*:\\s*\"([^\"]*)\"", "<$1>$2</$1>")
                .replaceAll("\"([^\"]*)\"\\s*:\\s*(\\d+)", "<$1>$2</$1>")
                .replaceAll("\\{", "<root>")
                .replaceAll("\\}", "</root>");

        System.out.println(xml);
    }
}