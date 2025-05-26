import java.util.*;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toJson() {
        return "{\"title\":\"" + title + "\",\"author\":\"" + author + "\"}";
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Java Basics", "John Doe"),
                new Book("Advanced Java", "Jane Smith")
        );

        StringBuilder jsonArray = new StringBuilder("[");
        for (Book book : books) {
            if (jsonArray.length() > 1) jsonArray.append(",");
            jsonArray.append(book.toJson());
        }
        jsonArray.append("]");

        System.out.println(jsonArray.toString());
    }
}