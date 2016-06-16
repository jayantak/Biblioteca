package biblioteca.library;

import biblioteca.io.ConsoleIO;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class LibraryTest {

    private List<String> menuItems;
    private ConsoleIO consoleIO;
    private BookList inventory;
    private BookList checkedOut;

    @Before
    public void setUp() throws Exception {
        menuItems = Arrays.asList("Exit", "List Books", "Checkout Book", "Return Book");
        consoleIO = mock(ConsoleIO.class);
        inventory = mock(BookList.class);
        checkedOut = mock(BookList.class);
    }

    @Test
    public void welcomeMessage() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(consoleIO).display("Welcome to Biblioteca!");
    }

    @Test
    public void mainMenuShouldPrintMenu() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(0);
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(consoleIO).mainMenu(menuItems);
    }

    @Test
    public void executingOption1ShouldPrintListOfBooks() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(1).thenReturn(0);
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(consoleIO).printBookList(inventory, "%50s %30s %15s\n");
    }

    @Test
    public void executingOption0ShouldShowInvalidOption() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(-1).thenReturn(0);
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(consoleIO).invalidOption();
    }

    @Test
    public void executingOption2ShouldCheckoutBook() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(2).thenReturn(0);
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(consoleIO).inputBookTitle();
    }


    @Test
    public void checkingOutWithExistingBookShouldDoSuccessfulCheckout() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(2).thenReturn(0);
        when(consoleIO.inputBookTitle()).thenReturn("Book Name");
        when(inventory.findBookByName("Book Name")).thenReturn(new Book("Book Name", "Author", 1000));
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(inventory).move(checkedOut, new Book("Book Name", "Author", 1000));
    }

    @Test
    public void executingOption2WithExistingBookShouldDisplaySuccessfulCheckoutMessage() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(2).thenReturn(0);
        when(consoleIO.inputBookTitle()).thenReturn("Book Name");
        when(inventory.findBookByName("Book Name")).thenReturn(new Book("Book Name", "Author", 1000));
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(consoleIO).display("Thank you! Enjoy the book!");
    }

    @Test
    public void returningExistingBookShouldRemoveBookFromCheckedOutAndAddToInventory() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(3).thenReturn(0);
        when(consoleIO.inputBookTitle()).thenReturn("Book Name");
        when(checkedOut.findBookByName("Book Name")).thenReturn(new Book("Book Name", "Author", 1000));
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(checkedOut).remove(new Book("Book Name", "Author", 1000));
        verify(inventory).add(new Book("Book Name", "Author", 1000));
    }

    @Test
    public void returningBookInInventoryShouldDisplayNotCheckedOut() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(3).thenReturn(0);
        when(consoleIO.inputBookTitle()).thenReturn("Book Name");
        when(checkedOut.findBookByName("Book Name")).thenReturn(null);
        when(inventory.findBookByName("Book Name")).thenReturn(new Book("Book Name", "Author", 1000));
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(consoleIO).display("That book has not been checked out!");
    }

    @Test
    public void returningBookInInventoryShouldDisplayDoesNotExist() {
        Library library = new Library(inventory, consoleIO, checkedOut);
        when(consoleIO.mainMenu(menuItems)).thenReturn(3).thenReturn(0);
        when(consoleIO.inputBookTitle()).thenReturn("Book Name");
        when(checkedOut.findBookByName("Book Name")).thenReturn(null);
        when(inventory.findBookByName("Book Name")).thenReturn(null);
        Menu menu = new Menu(consoleIO, library);
        menu.enter();
        verify(consoleIO).display("Sorry that book does not exist!");
    }
}
