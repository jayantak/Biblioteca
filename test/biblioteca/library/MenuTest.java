package biblioteca.library;

import biblioteca.io.ConsoleIO;
import biblioteca.library.menuCommands.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

public class MenuTest {
    private ConsoleIO consoleIO;
    private BookList available;
    private BookList checkedOut;
    private Library library;
    private List<LibraryFunction> options = new ArrayList<>();
    private List<String> menuItems = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        consoleIO = mock(ConsoleIO.class);
        available = mock(BookList.class);
        checkedOut = mock(BookList.class);
        library = mock(Library.class);

        LibraryFunction exit = mock(Exit.class);
        options.add(exit);
        LibraryFunction listBooks = mock(ListBooks.class);
        options.add(listBooks);
        LibraryFunction checkoutBook = mock((CheckoutBook.class));
        options.add(checkoutBook);
        ReturnBook returnBook = mock(ReturnBook.class);
        options.add(returnBook);

        menuItems = options.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    @Test
    public void welcomeMessage() {

        Menu menu = new Menu(consoleIO, options);
        menu.enter();
        verify(consoleIO).display("Welcome to Biblioteca!");
    }

    @Test
    public void mainMenuShouldPrintMenu() {
        when(consoleIO.mainMenu(menuItems)).thenReturn(0);
        Menu menu = new Menu(consoleIO, options);
        menu.enter();
        verify(consoleIO).mainMenu(menuItems);
    }

    @Test
    public void executingOption1ShouldRunCommand1() {
        when(consoleIO.mainMenu(menuItems)).thenReturn(1).thenReturn(0);
        Menu menu = new Menu(consoleIO, options);
        menu.enter();
        verify(options.get(1)).run();
    }

    @Test
    public void executingOption2ShouldRunCommand2() {
        when(consoleIO.mainMenu(menuItems)).thenReturn(2).thenReturn(0);
        Menu menu = new Menu(consoleIO, options);
        menu.enter();
        verify(options.get(2)).run();
    }
}