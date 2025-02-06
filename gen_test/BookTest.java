package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBookInitialization() {
        Book book = new Book("123-456-789", "Test Title", "Test Author", "Fiction", 2022);
        assertEquals("123-456-789", book.getIsbn());
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals("Fiction", book.getGenre());
        assertEquals(2022, book.getYear());
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testBorrowAndReturn() {
        Book book = new Book("123-456-789", "Test Title", "Test Author", "Fiction", 2022);
        
        book.borrow();
        assertTrue(book.isBorrowed());

        book.returnBook();
        assertFalse(book.isBorrowed());
    }
}

