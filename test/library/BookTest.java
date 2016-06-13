package library;

import org.junit.Test;

import static org.junit.Assert.*;

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
    public void createdBookShouldBeValid() {
        Book book = new Book("Book Name", "Author Name", 1999);
        Book createdCopyOfBook = Book.createBook("Book Name,Author Name,1999");
        assertEquals(book, createdCopyOfBook);
    }

    @Test
    public void displayShouldShowData() {
        Book book = new Book("Book Name", "Author Name", 1999);
        assertEquals("Book Name\tAuthor Name\t1999", book.display());
    }
}