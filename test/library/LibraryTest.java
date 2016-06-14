package library;

import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class LibraryTest {

    @Test
    public void shouldShowListOfBooks() throws FileNotFoundException {

        BookList books = new BookList();

        Book book = new Book("Book Name", "Author Name", 1999);
        Book anotherBook = new Book("Another", "Author Name", 1999);
        books.add(book);
        books.add(anotherBook);
        Library library = new Library(books);

        assertEquals(books, library.bookList());
    }

    @Test
    public void welcomeMessage() {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList bookList = new BookList();
        Library library = new Library(bookList, consoleIO);
        library.enter();
        verify(consoleIO).display("Welcome to Biblioteca!");
    }

    @Test
    public void mainMenuShouldPrintMenu() throws FileNotFoundException {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList bookList = new BookList();
        Library library = new Library(bookList, consoleIO);
        when(consoleIO.mainMenu()).thenReturn(0);
        library.enter();
        verify(consoleIO).mainMenu();
    }

    @Test
    public void executingOption1ShouldPrintListOfBooks() throws FileNotFoundException {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList bookList = new BookList();
        Library library = new Library(bookList, consoleIO);
        when(consoleIO.mainMenu()).thenReturn(1).thenReturn(0);
        library.enter();
        verify(consoleIO).printBookList(bookList, "%30s %30s %30s\n");
    }

    @Test
    public void executingOption0ShouldShowInvalidOption() throws FileNotFoundException {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList bookList = new BookList();
        Library library = new Library(bookList, consoleIO);
        when(consoleIO.mainMenu()).thenReturn(-1).thenReturn(0);
        library.enter();
        verify(consoleIO).invalidOption();
    }
}
