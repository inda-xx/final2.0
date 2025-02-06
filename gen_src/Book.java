public class Book {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isBorrowed;

    public Book(int id, String title, String author, int publicationYear) {
        // Constructor implementation
    }

    public int getId() {
        // Return book ID
    }

    public String getTitle() {
        // Return book title
    }

    public boolean isBorrowed() {
        // Return whether the book is borrowed
    }

    public void borrowBook() {
        // Borrow book logic
    }

    public void returnBook() {
        // Return book logic
    }

    @Override
    public String toString() {
        // Return string representation of book
    }
}