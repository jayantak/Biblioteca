package biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void bookShouldBeEqualToItself() {
        Book book = new Book("Book Name", "Author Name", 1999);
        assertEquals(book, book);
    }

    @Test
    public void copyOfBookShouldBeEqualToItself() {
        Book book = new Book("Book Name", "Author Name", 1999);
        Book copyOfBook = new Book("Book Name", "Author Name", 1999);
        assertEquals(book, copyOfBook);
    }

    @Test
    public void displayShouldShowData() {
        Book book = new Book("Book Name", "Author Name", 1999);
        assertEquals(String.format("%30s %30s %30s\n", "Book Name", "Author Name", "1999"), book.toString("%30s %30s %30s\n"));
    }
}