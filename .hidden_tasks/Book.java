public class Book {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isBorrowed;

    public Book(int id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isBorrowed = false; 
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " has been borrowed!");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " has been returned!");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return id + ": " + title + " by " + author + " (" + publicationYear + ") " 
               + (isBorrowed ? "[Borrowed]" : "[Available]");
    }
}