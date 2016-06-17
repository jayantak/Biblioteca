package biblioteca.library.menuOptions;

import org.junit.Test;

public class ExitTest {

    @Test
    public void shouldAlwaysReturnFalse() {
        MenuOption menuOption = new Exit();
        menuOption.run();
    }
}