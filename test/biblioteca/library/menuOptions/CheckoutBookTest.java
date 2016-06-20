package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.User;
import biblioteca.library.user.UserAuthenticator;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookTest {

    @Test
    public void shouldDisplayMessageWhenBookIsCheckedOut() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        CheckoutBook checkoutBook = new CheckoutBook(userIO, library, userAuthenticator);
        Book book = mock(Book.class);
        when(userIO.inputLine()).thenReturn("Book");
        when(library.getCheckedOutBookByName("Book")).thenReturn(book);
        when(userAuthenticator.loggedIn()).thenReturn(true);

        checkoutBook.run();

        verify(userIO).display("Sorry that book is checked out!");
    }

    @Test
    public void shouldCheckoutWhenBookIsAvailable() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        User user = mock(User.class);
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        CheckoutBook checkoutBook = new CheckoutBook(userIO, library, userAuthenticator);
        Book book = mock(Book.class);
        when(userIO.inputLine()).thenReturn("Book");
        when(library.getCheckedOutBookByName("Book")).thenReturn(Lendable.NO_LENDABLE);
        when(library.getAvailableBookByName("Book")).thenReturn(book);
        when(userAuthenticator.getCurrentUser()).thenReturn(user);
        when(userAuthenticator.loggedIn()).thenReturn(true);

        checkoutBook.run();

        verify(library).checkoutLendable(book, user);
        verify(userIO).display("Thank you! Enjoy the book!");
    }

    @Test
    public void shouldDisplayMessageWhenBooDoesNotExist() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        CheckoutBook checkoutBook = new CheckoutBook(userIO, library, userAuthenticator);
        Book book = mock(Book.class);
        when(userIO.inputLine()).thenReturn("Book");
        when(library.getCheckedOutBookByName("Book")).thenReturn(Lendable.NO_LENDABLE);
        when(library.getAvailableBookByName("Book")).thenReturn(Lendable.NO_LENDABLE);
        when(userAuthenticator.loggedIn()).thenReturn(true);

        checkoutBook.run();

        verify(userIO).display("Sorry that book does not exist!");
    }
}