package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.user.User;
import biblioteca.library.user.UserAuthenticator;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class LogInTest {

    @Test
    public void requiresLoginToBeTrueToBeFalse() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);

        LogIn logIn = new LogIn(userIO, userAuthenticator);
        when(userAuthenticator.loggedIn()).thenReturn(true);

        assertFalse(logIn.accessAvailable());
    }

    @Test
    public void requiresLoggedInToBeFalseToBeTrue() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);

        LogIn logIn = new LogIn(userIO, userAuthenticator);
        when(userAuthenticator.loggedIn()).thenReturn(false);

        assertTrue(logIn.accessAvailable());
    }

    @Test
    public void loginShouldLoginAtAuthenticator() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);

        when(userIO.inputLine()).thenReturn("id").thenReturn("pass");
        LogIn logIn = new LogIn(userIO, userAuthenticator);

        logIn.run();

        verify(userIO).display("Enter username:");
        verify(userIO).display("Enter password:");
        verify(userAuthenticator).login(new User("id", "pass"));
    }

    @Test
    public void successfulLoginShouldDisplayMessage() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);

        when(userIO.inputLine()).thenReturn("id").thenReturn("pass");
        when(userAuthenticator.login(new User("id", "pass"))).thenReturn(true);
        LogIn logIn = new LogIn(userIO, userAuthenticator);

        logIn.run();
        verify(userIO).display("Login successful!");
    }

    @Test
    public void unsuccessfulLoginShouldDisplayMessage() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);

        when(userIO.inputLine()).thenReturn("id").thenReturn("pass");
        when(userAuthenticator.login(new User("id", "pass"))).thenReturn(false);
        LogIn logIn = new LogIn(userIO, userAuthenticator);

        logIn.run();
        verify(userIO).display("Username or password wrong!");
    }
}