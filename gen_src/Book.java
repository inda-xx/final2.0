public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int year;
    private boolean isBorrowed;

    public Book(String isbn, String title, String author, String genre, int year) {
        // Constructor implementation
    }

    public String getIsbn() {
        return null; // Return the ISBN
    }

    public String getTitle() {
        return null; // Return the title
    }

    public String getAuthor() {
        return null; // Return the author
    }

    public String getGenre() {
        return null; // Return the genre
    }

    public int getYear() {
        return 0; // Return the year
    }

    public boolean isBorrowed() {
        return false; // Return borrow status
    }

    public void borrow() {
        // Implement borrowing logic
    }

    public void returnBook() {
        // Implement return logic
    }
}