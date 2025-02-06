import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooksByGenre(String genre) {
        return books.stream()
                    .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                    .sorted(Comparator.comparingInt(Book::getYear).reversed())
                    .collect(Collectors.toList());
    }

    public void loadBooksFromFile(String filename) {
        books.addAll(LibraryFileReader.readBooksFromFile(filename));
    }

    public List<Book> getBooksSortedByTitle() {
        return books.stream()
                    .sorted(Comparator.comparing(Book::getTitle))
                    .collect(Collectors.toList());
    }

    public List<Book> searchBooksByTitle(String keyword) {
        return books.stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
    }

    public boolean borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isBorrowed()) {
                    book.borrow();
                    return true;
                } else {
                    System.out.println("Book is already borrowed.");
                    return false;
                }
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    return true;
                } else {
                    System.out.println("Book was not borrowed.");
                    return false;
                }
            }
        }
        System.out.println("Book not found.");
        return false;
    }
}