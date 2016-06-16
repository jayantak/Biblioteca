package biblioteca.library;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void availableBookShouldBeFoundByName() {
        BookList available = mock(BookList.class);
        BookList checkedOut = mock(BookList.class);
        Library library = new Library(available, checkedOut);
        library.getAvailableBookByName("Book Name");
        verify(available).findBookByName("Book Name");
    }

    @Test
    public void checkedOutBookShouldBeFoundByName() {
        BookList available = mock(BookList.class);
        BookList checkedOut = mock(BookList.class);
        Library library = new Library(available, checkedOut);
        library.getCheckedOutBookByName("Book Name");
        verify(checkedOut).findBookByName("Book Name");
    }

    @Test
    public void checkoutBookShouldMoveBookFromCheckedOutToAvailable() {
        BookList available = mock(BookList.class);
        BookList checkedOut = mock(BookList.class);
        Library library = new Library(available, checkedOut);
        Book book = mock(Book.class);
        library.checkoutBook(book);
        verify(available).move(checkedOut, book);
    }

    @Test
    public void returnBookShouldMoveBookFromCheckedOutToAvailable() {
        BookList available = mock(BookList.class);
        BookList checkedOut = mock(BookList.class);
        Library library = new Library(available, checkedOut);
        Book book = mock(Book.class);
        library.returnBook(book);
        verify(checkedOut).move(available, book);
    }
}
