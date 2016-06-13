package library;

import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertEquals;

public class LibraryTest {

    @Test
    public void shouldShowListOfBooks() throws FileNotFoundException {

        BookList books = new BookList();

        Book book = new Book("Book Name", "Author Name", 1999);
        Book anotherBook= new Book("Another", "Author Name", 1999);
        books.add(book);
        books.add(anotherBook);
        Library library = Library.createLibrary(books);

        assertEquals(books, library.bookList());
    }
}
