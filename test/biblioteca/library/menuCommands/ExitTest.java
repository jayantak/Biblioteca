package biblioteca.library.menuCommands;

import org.junit.Test;

public class ExitTest {

    @Test
    public void shouldAlwaysReturnFalse() {
        LibraryFunction libraryFunction = new Exit();
        libraryFunction.run();
    }
}