package biblioteca.library;

import io.ConsoleIO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class LibraryTest {

    @Test
    public void shouldShowListOfBooks() {

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
        BookList bookList = mock(BookList.class);
        Library library = new Library(bookList, consoleIO);
        library.enter();
        verify(consoleIO).display("Welcome to Biblioteca!");
    }

    @Test
    public void mainMenuShouldPrintMenu() {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList bookList = mock(BookList.class);
        Library library = new Library(bookList, consoleIO);
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book");
        when(consoleIO.mainMenu(menuItems)).thenReturn(0);
        library.enter();
        verify(consoleIO).mainMenu(menuItems);
    }

    @Test
    public void executingOption1ShouldPrintListOfBooks() {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList bookList = mock(BookList.class);
        Library library = new Library(bookList, consoleIO);
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book");
        when(consoleIO.mainMenu(menuItems)).thenReturn(1).thenReturn(0);
        library.enter();
        verify(consoleIO).printBookList(bookList, "%30s %30s %30s\n");
    }

    @Test
    public void executingOption0ShouldShowInvalidOption() {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList bookList = mock(BookList.class);
        Library library = new Library(bookList, consoleIO);
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book");
        when(consoleIO.mainMenu(menuItems)).thenReturn(-1).thenReturn(0);
        library.enter();
        verify(consoleIO).invalidOption();
    }

    @Test
    public void executingOption2ShouldCheckoutBook() {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList bookList = mock(BookList.class);
        Library library = new Library(bookList, consoleIO);
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book");
        when(consoleIO.mainMenu(menuItems)).thenReturn(2).thenReturn(0);
        library.enter();
        verify(consoleIO).inputBookTitle();
    }


    @Test
    public void executingOption2WithExistingBookShouldDoSuccessfulCheckout() {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList books = mock(BookList.class);
        Library library = new Library(books, consoleIO);
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book");
        when(consoleIO.mainMenu(menuItems)).thenReturn(2).thenReturn(0);
        when(consoleIO.inputBookTitle()).thenReturn("Book Name");
        when(books.findBookByName("Book Name")).thenReturn(new Book("Book Name", "Author", 1000));
        library.enter();
        verify(books).remove(new Book("Book Name", "Author", 1000));
    }

    @Test
    public void executingOption2WithExistingBookShouldDisplaySuccessfulCheckoutMessage() {
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        BookList books = mock(BookList.class);
        Library library = new Library(books, consoleIO);
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book");
        when(consoleIO.mainMenu(menuItems)).thenReturn(2).thenReturn(0);
        when(consoleIO.inputBookTitle()).thenReturn("Book Name");
        when(books.findBookByName("Book Name")).thenReturn(new Book("Book Name", "Author", 1000));
        library.enter();
        verify(consoleIO).display("Thank you! Enjoy the book!");
    }
}
