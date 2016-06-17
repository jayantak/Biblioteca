package biblioteca.library;

import biblioteca.library.lendableItems.Book;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LibraryTest {

    @Test
    public void availableBookShouldBeFoundByName() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, checkedOut);
        when(available.findByName("Book Name")).thenReturn(mock(Book.class));
        library.getAvailableBookByName("Book Name");
        verify(available).findByName("Book Name");
    }

    @Test
    public void checkedOutBookShouldBeFoundByName() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, checkedOut);
        when(checkedOut.findByName("Book Name")).thenReturn(mock(Book.class));
        library.getCheckedOutBookByName("Book Name");
        verify(checkedOut).findByName("Book Name");
    }

    @Test
    public void checkoutBookShouldMoveBookFromCheckedOutToAvailable() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, checkedOut);
        Book book = mock(Book.class);
        library.checkoutLendable(book);
        verify(available).move(checkedOut, book);
    }

    @Test
    public void returnBookShouldMoveBookFromCheckedOutToAvailable() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, checkedOut);
        Book book = mock(Book.class);
        library.returnLendable(book);
        verify(checkedOut).move(available, book);
    }
}
