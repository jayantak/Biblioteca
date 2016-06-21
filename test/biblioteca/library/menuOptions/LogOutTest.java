package biblioteca.library.menuOptions;

import biblioteca.library.user.UserAuthenticator;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LogOutTest {

    @Test
    public void requiresLoginToBeTrue() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);

        LogOut logOut = new LogOut(userAuthenticator);
        when(userAuthenticator.loggedIn()).thenReturn(true);

        assertTrue(logOut.accessAvailable());
    }

    @Test
    public void requiresLoggedOutToBeFalse() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);

        LogOut logOut = new LogOut(userAuthenticator);
        when(userAuthenticator.loggedIn()).thenReturn(false);

        assertFalse(logOut.accessAvailable());
    }

    @Test
    public void shouldLogOut() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);

        LogOut logOut = new LogOut(userAuthenticator);
        logOut.run();

        verify(userAuthenticator).logout();
    }
}