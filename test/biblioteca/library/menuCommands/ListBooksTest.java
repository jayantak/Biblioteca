package biblioteca.library.menuCommands;

import biblioteca.io.ConsoleIO;
import biblioteca.io.UserIO;
import biblioteca.library.Book;
import biblioteca.library.BookList;
import biblioteca.library.Library;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListBooksTest {

    @Test
    public void shouldPrintBookList() {
        UserIO userIO = mock(ConsoleIO.class);
        Library library = mock(Library.class);
        BookList books = mock(BookList.class);
        Book book = mock(Book.class);

        ListBooks listBooks = new ListBooks(userIO, library);

        when(library.available()).thenReturn(books);
        when(books.get(0)).thenReturn(book);

        listBooks.run();

        verify(userIO).printBookList(books, "%50s %30s %15s\n");
    }
}