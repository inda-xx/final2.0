import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooksFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    int year = Integer.parseInt(parts[3].trim());
                    books.add(new Book(id, title, author, year));
                }
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
}