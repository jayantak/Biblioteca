package biblioteca.library;

import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LendableListTest {

    @Test
    public void bookShouldBeFoundByName() {
        LendableList books = new LendableList();

        Book book = new Book("Book Name", "Author Name", 1999);
        Book anotherBook = new Book("Another", "Author Name", 1999);
        books.put(book, User.NO_USER);
        books.put(anotherBook, User.NO_USER);

        assertEquals(book, books.findByName("Book Name", User.NO_USER));
    }

    @Test
    public void absentBookShouldCauseReturnOfNull() {
        LendableList books = new LendableList();

        Book book = new Book("Book Name", "Author Name", 1999);
        books.put(book, User.NO_USER);

        assertEquals(Lendable.NO_LENDABLE, books.findByName("Another", User.NO_USER));
    }
}