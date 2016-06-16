package biblioteca.io;

import biblioteca.library.Book;
import biblioteca.library.LendableList;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTextFileDataInputTest {

    @Test
    public void scanOfInputBookFileShouldConstructBookList() throws IOException {
        BufferedReader fileInput = mock(BufferedReader.class);
        LibraryDataInput libraryDataInput = new LibraryTextFileDataInput(fileInput);
        when(fileInput.readLine()).thenReturn("The Book Thief,Marcus Zusak,2006").thenReturn(null);

        LendableList books = new LendableList();
        books.add(new Book("The Book Thief", "Marcus Zusak", 2006));
        assertEquals(books, libraryDataInput.getBookList());
    }
}