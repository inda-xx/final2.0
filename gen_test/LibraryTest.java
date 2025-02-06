package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testBookCreation() {
        Book book = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        assertEquals(1, book.getId());
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
        assertEquals(1925, book.getPublicationYear());
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testBorrowBook() {
        Book book = new Book(1, "1984", "George Orwell", 1949);
        assertFalse(book.isBorrowed());
        book.borrowBook();
        assertTrue(book.isBorrowed());
        book.borrowBook();  // Should not change state
        assertTrue(book.isBorrowed());
    }

    @Test
    public void testReturnBook() {
        Book book = new Book(1, "Brave New World", "Aldous Huxley", 1932);
        book.borrowBook();
        assertTrue(book.isBorrowed());
        book.returnBook();
        assertFalse(book.isBorrowed());
        book.returnBook();  // Should not change state
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testLibraryAddBook() {
        Library library = new Library();
        assertEquals(0, library.getBooks().size());

        library.addBook(new Book(1, "Moby Dick", "Herman Melville", 1851));
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testSearchBookByTitle() {
        Library library = new Library();
        library.addBook(new Book(1, "The Hobbit", "J.R.R. Tolkien", 1937));
        library.addBook(new Book(2, "The Lord of the Rings", "J.R.R. Tolkien", 1954));

        List<Book> foundBooks = library.searchBookByTitle("The Hobbit");
        assertEquals(1, foundBooks.size());
        assertEquals("The Hobbit", foundBooks.get(0).getTitle());

        foundBooks = library.searchBookByTitle("The Lord of the Rings");
        assertEquals(1, foundBooks.size());

        foundBooks = library.searchBookByTitle("Nonexistent");
        assertTrue(foundBooks.isEmpty());
    }

    @Test
    public void testBorrowAndReturnBookInLibrary() {
        Library library = new Library();
        Book book = new Book(1, "Dune", "Frank Herbert", 1965);

        library.addBook(book);
        library.borrowBook(1);
        assertTrue(book.isBorrowed());

        library.returnBook(1);
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testBorrowNonexistentBook() {
        Library library = new Library();
        library.borrowBook(99);  // Should not throw exception
    }

    @Test
    public void testReturnNonexistentBook() {
        Library library = new Library();
        library.returnBook(99);  // Should not throw exception
    }

    @Test
    public void testLoadBooksFromFile() {
        Library library = new Library();
        library.loadBooksFromFile("test_books.txt");
        
        // Assuming test_books.txt contains entries
        assertTrue(library.getBooks().size() > 0);
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

