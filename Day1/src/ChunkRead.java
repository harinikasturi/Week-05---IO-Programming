import java.io.*;

public class ChunkRead {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("large.csv"));
        String line = reader.readLine(); // skip header
        int chunkSize = 100;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            count++;
            if (count % chunkSize == 0) {
                System.out.println("Processed: " + count);
            }
        }
        System.out.println("Total Records: " + count);
        reader.close();
    }
}
