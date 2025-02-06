package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("123-456-789", "Test Book", "Author Name", "Fiction", 2020);
        library.addBook(book);
        List<Book> books = library.getBooksSortedByTitle();
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByGenre() {
        Library library = new Library();
        Book book1 = new Book("123", "Fiction Book", "Author A", "Fiction", 2010);
        Book book2 = new Book("456", "Non-Fiction Book", "Author B", "Non-Fiction", 2015);
        Book book3 = new Book("789", "Another Fiction", "Author C", "Fiction", 2020);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> fictionBooks = library.getBooksByGenre("Fiction");
        assertEquals(2, fictionBooks.size());
        assertEquals("Another Fiction", fictionBooks.get(0).getTitle());
    }

    @Test
    public void testSearchBooksByTitle() {
        Library library = new Library();
        Book book1 = new Book("123", "The Great Adventure", "Author X", "Fiction", 2005);
        Book book2 = new Book("456", "A Great Journey", "Author Y", "Adventure", 2012);
        Book book3 = new Book("789", "Simple Book", "Author Z", "Non-Fiction", 2018);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> searchResults = library.searchBooksByTitle("Great");
        assertEquals(2, searchResults.size());
        assertTrue(searchResults.get(0).getTitle().contains("Great"));
    }

    @Test
    public void testBorrowBook() {
        Library library = new Library();
        Book book = new Book("123-456-789", "Test Book", "Author Name", "Fiction", 2020);
        library.addBook(book);
        
        assertTrue(library.borrowBook("123-456-789"));
        assertFalse(library.borrowBook("123-456-789"));
        assertFalse(library.borrowBook("999-999-999"));
    }

    @Test
    public void testReturnBook() {
        Library library = new Library();
        Book book = new Book("123-456-789", "Test Book", "Author Name", "Fiction", 2020);
        library.addBook(book);
        
        assertFalse(library.returnBook("123-456-789"));
        library.borrowBook("123-456-789");
        assertTrue(library.returnBook("123-456-789"));
    }
}

