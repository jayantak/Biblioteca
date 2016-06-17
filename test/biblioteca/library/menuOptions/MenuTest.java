package biblioteca.library.menuOptions;

import biblioteca.io.ConsoleIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.menuFunctions.MenuInput;
import biblioteca.library.menuFunctions.Start;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

public class MenuTest {
    private ConsoleIO consoleIO;
    private LendableList available;
    private LendableList checkedOut;
    private Library library;
    private List<MenuOption> options = new ArrayList<>();
    private List<String> menuItems = new ArrayList<>();
    private MenuOption invalid;
    private Start start;
    private MenuInput input;

    @Before
    public void setUp() throws Exception {
        consoleIO = mock(ConsoleIO.class);
        available = mock(LendableList.class);
        checkedOut = mock(LendableList.class);
        library = mock(Library.class);
        start = mock(Start.class);
        input = mock(MenuInput.class);

        MenuOption exit = mock(Exit.class);
        options.add(exit);
        MenuOption listBooks = mock(ListBooks.class);
        options.add(listBooks);
        MenuOption checkoutBook = mock((CheckoutBook.class));
        options.add(checkoutBook);
        ReturnBook returnBook = mock(ReturnBook.class);
        options.add(returnBook);

        menuItems = options.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        invalid = new PrintInvalid(consoleIO);
    }

    @Test
    public void welcomeMessage() {

        Menu menu = new Menu(start, input, options, invalid, "Main Menu");
        menu.run();
        verify(start).print();
    }

    @Test
    public void mainMenuShouldPrintMenu() {
        when(input.choice(menuItems)).thenReturn(0);
        Menu menu = new Menu(start, input, options, invalid, "Main Menu");
        menu.run();
        verify(options.get(0)).run();
    }

    @Test
    public void executingOption1ShouldRunCommand1() {
        when(input.choice(menuItems)).thenReturn(1).thenReturn(0);
        Menu menu = new Menu(start, input, options, invalid, "Main Menu");
        menu.run();
        verify(options.get(1)).run();
    }

    @Test
    public void executingOption2ShouldRunCommand2() {
        when(input.choice(menuItems)).thenReturn(2).thenReturn(0);
        Menu menu = new Menu(start, input, options, invalid, "Main Menu");
        menu.run();
        verify(options.get(2)).run();
    }
}