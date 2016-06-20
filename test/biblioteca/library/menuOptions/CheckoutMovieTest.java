package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.lendableItems.Movie;
import biblioteca.library.user.UserAuthenticator;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutMovieTest {

    @Test
    public void shouldDisplayMessageWhenMovieIsCheckedOut() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        CheckoutMovie checkoutMovie = new CheckoutMovie(userIO, library, userAuthenticator);
        Movie movie = mock(Movie.class);
        when(userIO.inputLine()).thenReturn("Movie");
        when(library.getCheckedOutMovieByName("Movie")).thenReturn(movie);

        checkoutMovie.run();

        verify(userIO).display("Sorry that movie is checked out!");
    }

    @Test
    public void shouldDisplayMessageWhenBooDoesNotExist() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        CheckoutMovie checkoutMovie = new CheckoutMovie(userIO, library, userAuthenticator);
        when(userIO.inputLine()).thenReturn("Movie");
        when(library.getCheckedOutMovieByName("Movie")).thenReturn(Lendable.NO_LENDABLE);
        when(library.getAvailableMovieByName("Movie")).thenReturn(Lendable.NO_LENDABLE);

        checkoutMovie.run();

        verify(userIO).display("Sorry that movie does not exist!");
    }
}