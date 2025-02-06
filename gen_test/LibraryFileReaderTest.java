package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryFileReaderTest {

    @Test
    public void testReadBooksFromFile() throws IOException {
        File tempFile = File.createTempFile("books", ".txt");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("123,Test Book,Author,Fiction,2000\n");
        writer.write("456,Bad Entry,Missing Field\n");
        writer.write("789,Another Book,Writer,Non-Fiction,2018\n");
        writer.close();

        List<Book> books = LibraryFileReader.readBooksFromFile(tempFile.getAbsolutePath());
        assertEquals(2, books.size());
        assertEquals("Test Book", books.get(0).getTitle());
        assertEquals("Another Book", books.get(1).getTitle());

        tempFile.delete();
    }
}

