package biblioteca.library.menuFunctions;

import biblioteca.io.UserIO;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StartTest {

    @Test
    public void shouldDisplayWelcomeMessage() {
        UserIO userIO = mock(UserIO.class);
        String welcomeMessage = "hello";

        Start start = new Start(userIO, welcomeMessage);

        start.print();

        verify(userIO).display("----------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------\n" + welcomeMessage);
    }
}