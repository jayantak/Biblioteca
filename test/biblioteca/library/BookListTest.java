package biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookListTest {

    @Test
    public void bookShouldBeFoundByName() {
        BookList books = new BookList();

        Book book = new Book("Book Name", "Author Name", 1999);
        Book anotherBook = new Book("Another", "Author Name", 1999);
        books.add(book);
        books.add(anotherBook);

        assertEquals(book, books.findBookByName("Book Name"));
    }

    @Test
    public void absentBookShouldCauseReturnOfNull() {
        BookList books = new BookList();

        Book book = new Book("Book Name", "Author Name", 1999);
        books.add(book);

        assertEquals(null, books.findBookByName("Another"));
    }
}