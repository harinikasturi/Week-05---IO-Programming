public class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("Old feature - Deprecated");
    }

    void newFeature() {
        System.out.println("New feature - Use this instead");
    }
}

class Main1 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
