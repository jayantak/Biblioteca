package biblioteca.library;

import biblioteca.library.lendableItems.Book;
import biblioteca.library.user.UserAuthenticator;
import org.junit.Before;
import org.junit.Test;

import static biblioteca.library.user.User.NO_USER;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private UserAuthenticator userAuthenticator;

    @Before
    public void setUp() throws Exception {
        userAuthenticator = mock(UserAuthenticator.class);
    }

    @Test
    public void availableBookShouldBeFoundByName() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, userAuthenticator);
        when(available.findByName("Book Name", NO_USER)).thenReturn(mock(Book.class));
        library.getAvailableBookByName("Book Name");
        verify(available).findByName("Book Name", NO_USER);
    }

    @Test
    public void checkoutBookShouldMoveBookFromCheckedOutToAvailable() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, userAuthenticator);
        Book book = mock(Book.class);
        library.checkoutLendable(book, NO_USER);
        verify(available).replace(book, NO_USER, NO_USER);
    }

    @Test
    public void returnBookShouldMoveBookFromCheckedOutToAvailable() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, userAuthenticator);
        Book book = mock(Book.class);
        library.returnLendable(book, NO_USER);
        verify(available).replace(book, NO_USER, NO_USER);
    }
}
