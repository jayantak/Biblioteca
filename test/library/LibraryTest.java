package library;

import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertEquals;

public class LibraryTest {

    @Test
    public void shouldShowListOfBooks() throws FileNotFoundException {
        Library library = new Library();
        assertEquals("Harry Potter\nAlan Wake", library.bookList());

    }
}
