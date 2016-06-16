package biblioteca.library.menuCommands;

import biblioteca.io.ConsoleIO;
import biblioteca.io.UserIO;
import biblioteca.library.Book;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListBooksTest {

    @Test
    public void shouldPrintBookList() {
        UserIO userIO = mock(ConsoleIO.class);
        Library library = mock(Library.class);
        LendableList books = mock(LendableList.class);
        Book book = mock(Book.class);

        ListBooks listBooks = new ListBooks(userIO, library);

        when(library.available()).thenReturn(books);
        when(books.get(0)).thenReturn(book);

        listBooks.run();

        verify(userIO).printList(books, new Book("", "", 0), "%50s %30s %15s\n");
    }
}