package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Book;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ReturnBookTest {

    @Test
    public void shouldDisplayMessageWhenBookIsReturnedButNotCheckedOut() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook(userIO, library);
        Book book = mock(Book.class);
        when(userIO.inputTitle()).thenReturn("Book");
        when(library.getAvailableBookByName("Book")).thenReturn(book);

        returnBook.run();

        verify(userIO).display("That book has not been checked out!");
    }

    @Test
    public void shouldCheckoutWhenBookIsAvailable() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook(userIO, library);
        Book book = mock(Book.class);
        when(userIO.inputTitle()).thenReturn("Book");
        when(library.getAvailableBookByName("Book")).thenReturn(null);
        when(library.getCheckedOutBookByName("Book")).thenReturn(book);

        returnBook.run();

        verify(library).returnLendable(book);
        verify(userIO).display("Thank you for returning the book!");
    }

    @Test
    public void shouldDisplayMessageWhenBooDoesNotExist() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        ReturnBook returnBook = new ReturnBook(userIO, library);
        when(userIO.inputTitle()).thenReturn("Book");
        when(library.getCheckedOutBookByName("Book")).thenReturn(null);
        when(library.getAvailableBookByName("Book")).thenReturn(null);

        returnBook.run();

        verify(userIO).display("Sorry that book does not exist!");
    }
}