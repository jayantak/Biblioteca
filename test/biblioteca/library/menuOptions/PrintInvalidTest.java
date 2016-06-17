package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrintInvalidTest {

    @Test
    public void shouldCallPrintInvalid() {
        UserIO userIO = mock(UserIO.class);
        PrintInvalid printInvalid = new PrintInvalid(userIO);
        printInvalid.run();
        verify(userIO).invalidOption();
    }
}