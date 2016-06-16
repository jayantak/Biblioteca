package biblioteca.library.menuCommands;

import biblioteca.io.UserIO;
import biblioteca.library.Book;
import biblioteca.library.Library;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookTest {

    @Test
    public void shouldDisplayMessageWhenBookIsCheckedOut() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        CheckoutBook checkoutBook = new CheckoutBook(userIO, library);
        Book book = mock(Book.class);
        when(userIO.inputBookTitle()).thenReturn("Book");
        when(library.getCheckedOutBookByName("Book")).thenReturn(book);

        checkoutBook.run();

        verify(userIO).display("Sorry that book is checked out!");
    }

    @Test
    public void shouldCheckoutWhenBookIsAvailable() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        CheckoutBook checkoutBook = new CheckoutBook(userIO, library);
        Book book = mock(Book.class);
        when(userIO.inputBookTitle()).thenReturn("Book");
        when(library.getCheckedOutBookByName("Book")).thenReturn(null);
        when(library.getAvailableBookByName("Book")).thenReturn(book);

        checkoutBook.run();

        verify(library).checkoutBook(book);
        verify(userIO).display("Thank you! Enjoy the book!");
    }

    @Test
    public void shouldDisplayMessageWhenBooDoesNotExist() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        CheckoutBook checkoutBook = new CheckoutBook(userIO, library);
        Book book = mock(Book.class);
        when(userIO.inputBookTitle()).thenReturn("Book");
        when(library.getCheckedOutBookByName("Book")).thenReturn(null);
        when(library.getAvailableBookByName("Book")).thenReturn(null);

        checkoutBook.run();

        verify(userIO).display("Sorry that book does not exist!");
    }
}