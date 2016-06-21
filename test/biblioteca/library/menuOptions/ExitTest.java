package biblioteca.library.menuOptions;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ExitTest {

    @Test
    public void shouldAlwaysReturnFalse() {
        MenuOption menuOption = new Exit();
        assertFalse(menuOption.run());
    }

    @Test
    public void doesNotRequireLogin() {
        Exit exit = new Exit();
        assertTrue(exit.accessAvailable());
    }
}