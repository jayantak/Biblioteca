package biblioteca.library.user;

import org.junit.Test;

import java.util.ArrayList;

import static biblioteca.library.user.User.NO_USER;
import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserAuthenticatorTest {

    @Test
    public void successfulLoginShouldReturnTrue() {

        ArrayList users = mock(ArrayList.class);
        User user = mock(User.class);
        when(users.contains(user)).thenReturn(true);
        when(users.indexOf(user)).thenReturn(0);
        when(users.get(0)).thenReturn(user);

        UserAuthenticator userAuthenticator = new UserAuthenticator(users);

        assertTrue(userAuthenticator.login(user));
    }

    @Test
    public void unsuccessfulLoginShouldReturnFalse() {

        ArrayList users = mock(ArrayList.class);
        User user = mock(User.class);
        when(users.contains(user)).thenReturn(false);
        when(users.indexOf(user)).thenReturn(0);
        when(users.get(0)).thenReturn(user);

        UserAuthenticator userAuthenticator = new UserAuthenticator(users);

        assertFalse(userAuthenticator.login(user));
    }

    @Test
    public void newUserAuthenticatorShouldBeLoggedOut() {

        ArrayList users = mock(ArrayList.class);
        UserAuthenticator userAuthenticator = new UserAuthenticator(users);

        assertFalse(userAuthenticator.loggedIn());
    }

    @Test
    public void loggingInShouldMakeItLoggedOut() {

        ArrayList users = mock(ArrayList.class);
        User user = mock(User.class);
        when(users.contains(user)).thenReturn(true);
        when(users.indexOf(user)).thenReturn(0);
        when(users.get(0)).thenReturn(user);

        UserAuthenticator userAuthenticator = new UserAuthenticator(users);

        userAuthenticator.login(user);

        assertTrue(userAuthenticator.loggedIn());
    }

    @Test
    public void loggingOutShouldMakeItLoggedOut() {

        ArrayList users = mock(ArrayList.class);
        User user = mock(User.class);
        when(users.contains(user)).thenReturn(true);
        when(users.indexOf(user)).thenReturn(0);
        when(users.get(0)).thenReturn(user);

        UserAuthenticator userAuthenticator = new UserAuthenticator(users);

        userAuthenticator.login(user);
        userAuthenticator.logout();

        assertFalse(userAuthenticator.loggedIn());
    }


    @Test
    public void loggingInShouldGiveCorrectLoggedInUser() {

        ArrayList users = mock(ArrayList.class);
        User user = mock(User.class);
        when(users.contains(user)).thenReturn(true);
        when(users.indexOf(user)).thenReturn(0);
        when(users.get(0)).thenReturn(user);

        UserAuthenticator userAuthenticator = new UserAuthenticator(users);

        userAuthenticator.login(user);

        assertEquals(user, userAuthenticator.getCurrentUser());
    }


    @Test
    public void loggingOutShouldGiveNOUSERLoggedIn() {

        ArrayList users = mock(ArrayList.class);
        User user = mock(User.class);
        when(users.contains(user)).thenReturn(true);
        when(users.indexOf(user)).thenReturn(0);
        when(users.get(0)).thenReturn(user);

        UserAuthenticator userAuthenticator = new UserAuthenticator(users);

        userAuthenticator.login(user);
        userAuthenticator.logout();

        assertEquals(NO_USER, userAuthenticator.getCurrentUser());
    }
}