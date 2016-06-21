package biblioteca.library.menuFunctions;

import biblioteca.io.ConsoleIO;
import biblioteca.io.UserIO;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuInputTest {

    @Test
    public void shouldCallMenuOnUserIO() {
        UserIO userIO = mock(ConsoleIO.class);
        ArrayList menuItems = mock(ArrayList.class);

        MenuInput menuInput = new MenuInput(userIO);
        menuInput.choice(menuItems);

        verify(userIO).menu(menuItems);
    }
}