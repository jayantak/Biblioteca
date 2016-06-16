package biblioteca.library;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void availableBookShouldBeFoundByName() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, checkedOut);
        library.getAvailableBookByName("Book Name");
        verify(available).findByName("Book Name");
    }

    @Test
    public void checkedOutBookShouldBeFoundByName() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, checkedOut);
        library.getCheckedOutBookByName("Book Name");
        verify(checkedOut).findByName("Book Name");
    }

    @Test
    public void checkoutBookShouldMoveBookFromCheckedOutToAvailable() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, checkedOut);
        Book book = mock(Book.class);
        library.checkoutBook(book);
        verify(available).move(checkedOut, book);
    }

    @Test
    public void returnBookShouldMoveBookFromCheckedOutToAvailable() {
        LendableList available = mock(LendableList.class);
        LendableList checkedOut = mock(LendableList.class);
        Library library = new Library(available, checkedOut);
        Book book = mock(Book.class);
        library.returnBook(book);
        verify(checkedOut).move(available, book);
    }
}
