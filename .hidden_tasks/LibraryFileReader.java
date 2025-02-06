import java.util.List;
import java.util.ArrayList;

public class LibraryFileReader {
    public static List<Book> readBooksFromFile(String filename) {
        List<Book> books = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String author = data[2].trim();
                    String genre = data[3].trim();
                    
                    try {
                        int year = Integer.parseInt(data[4].trim());
                        books.add(new Book(isbn, title, author, genre, year));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid year format for book: " + title);
                    }
                } else {
                    System.err.println("Skipping invalid entry: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return books;
    }
}