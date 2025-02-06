public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();
        library.loadBooksFromFile("books.txt");

        System.out.println("Books sorted by title:");
        for (Book book : library.getBooksSortedByTitle()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        System.out.println("\nSearching for 'Great':");
        for (Book book : library.searchBooksByTitle("Great")) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        System.out.println("\nFiction Books (sorted by year):");
        for (Book book : library.getBooksByGenre("Fiction")) {
            System.out.println(book.getTitle() + " - " + book.getYear());
        }

        System.out.println("\nBorrowing a book:");
        library.borrowBook("978-3-16-148410-0");

        System.out.println("\nReturning a book:");
        library.returnBook("978-3-16-148410-0");
    }
}