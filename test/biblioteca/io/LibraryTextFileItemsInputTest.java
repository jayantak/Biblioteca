package biblioteca.io;

import biblioteca.library.LendableList;
import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Movie;
import biblioteca.library.user.User;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTextFileItemsInputTest {

    @Test
    public void scanOfInputBookFileShouldConstructBookList() throws IOException {
        BufferedReader fileInput = mock(BufferedReader.class);
        LibraryItemsInput libraryItemsInput = new LibraryTextFileItemsInput(fileInput);
        when(fileInput.readLine()).thenReturn("The Book Thief,Marcus Zusak,2006").thenReturn(null);

        LendableList books = new LendableList();
        books.put(new Book("The Book Thief", "Marcus Zusak", 2006), User.NO_USER);
        assertEquals(books.get(0), libraryItemsInput.getItemList().get(0));
    }

    @Test
    public void scanOfInputMovieFileShouldConstructMovieList() throws IOException {
        BufferedReader fileInput = mock(BufferedReader.class);
        LibraryItemsInput libraryItemsInput = new LibraryTextFileItemsInput(fileInput);
        when(fileInput.readLine()).thenReturn("The Book Thief,Marcus Zusak,2006,5").thenReturn(null);

        LendableList items = new LendableList();
        items.put(new Movie("The Book Thief", "Marcus Zusak", 2006, 5), User.NO_USER);
        assertEquals(items.get(0), libraryItemsInput.getItemList().get(0));
    }
}