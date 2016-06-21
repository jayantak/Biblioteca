package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.user.User;
import biblioteca.library.user.UserAuthenticator;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserDetailsTest {


    @Test
    public void requiresLoginToBeTrue() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);

        UserDetails userDetails = new UserDetails(userIO, userAuthenticator);
        when(userAuthenticator.loggedIn()).thenReturn(true);

        assertTrue(userDetails.accessAvailable());
    }

    @Test
    public void requiresLoggedOutToBeFalse() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);

        UserDetails userDetails = new UserDetails(userIO, userAuthenticator);
        when(userAuthenticator.loggedIn()).thenReturn(false);

        assertFalse(userDetails.accessAvailable());
    }


    @Test
    public void shouldDisplayUserDetails() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);
        User user = new User("ID", "password", "Name", "Email", "Phone");
        when(userAuthenticator.getCurrentUser()).thenReturn(user);

        UserDetails userDetails = new UserDetails(userIO, userAuthenticator);

        userDetails.run();

        verify(userIO).display("Name\t=\tName" +
                "\nEmail\t=\tEmail" +
                "\nPhone\t=\tPhone");
    }

    @Test
    public void shouldDisplayUserDetailsForNOUSER() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);
        when(userAuthenticator.getCurrentUser()).thenReturn(User.NO_USER);

        UserDetails userDetails = new UserDetails(userIO, userAuthenticator);

        userDetails.run();

        verify(userIO).display("Name\t=\t" +
                "\nEmail\t=\t" +
                "\nPhone\t=\t");
    }

    @Test
    public void shouldDisplayUserDetailsForDummyUser() {
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        UserIO userIO = mock(UserIO.class);
        User user = new User("ID", "password");
        when(userAuthenticator.getCurrentUser()).thenReturn(user);

        UserDetails userDetails = new UserDetails(userIO, userAuthenticator);

        userDetails.run();

        verify(userIO).display("Name\t=\t" +
                "\nEmail\t=\t" +
                "\nPhone\t=\t");
    }
}