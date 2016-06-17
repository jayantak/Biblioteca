package biblioteca.library.menuOptions;

import biblioteca.io.ConsoleIO;
import biblioteca.io.UserIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Book;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListBooksTest {

    @Test
    public void shouldPrintBookList() {
        UserIO userIO = mock(ConsoleIO.class);
        Library library = mock(Library.class);
        LendableList books = new LendableList();
        Book book = new Book("", "", 0);
        books.add(book);

        ListBooks listBooks = new ListBooks(userIO, library);

        when(library.available()).thenReturn(books);

        listBooks.run();

        verify(userIO).printList(books, "%50s %30s %15s\n");
    }
}