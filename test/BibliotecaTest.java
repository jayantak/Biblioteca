import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BibliotecaTest {

    @Test
    public void openingAppShouldReturnWelcomeMessage() {
        assertEquals("Welcome to Biblioteca!", Biblioteca.welcomeMessage());
    }
}
