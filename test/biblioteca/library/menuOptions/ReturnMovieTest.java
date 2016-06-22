package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Movie;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.User;
import biblioteca.library.user.UserAuthenticator;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ReturnMovieTest {

    @Test
    public void shouldDisplayMessageWhenMovieIsReturnedButNotCheckedOut() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        ReturnMovie returnMovie = new ReturnMovie(userIO, library, userAuthenticator);
        Movie movie = mock(Movie.class);
        when(userIO.inputLine()).thenReturn("Movie");
        when(library.getAvailableMovieByName("Movie")).thenReturn(movie);

        returnMovie.run();

        verify(userIO).display("You have not checked out that movie!");
    }

    @Test
    public void shouldCheckoutWhenMovieIsAvailable() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        User user = mock(User.class);
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);
        ReturnMovie returnMovie = new ReturnMovie(userIO, library, userAuthenticator);
        Movie movie = mock(Movie.class);
        when(userIO.inputLine()).thenReturn("Movie");
        when(library.getAvailableMovieByName("Movie")).thenReturn(Lendable.NO_LENDABLE);
        when(library.getCheckedOutMovieByName("Movie")).thenReturn(movie);
        when(userAuthenticator.getCurrentUser()).thenReturn(user);

        returnMovie.run();

        verify(library).returnLendable(movie, user);
        verify(userIO).display("Thank you for returning the movie!");
    }

    @Test
    public void shouldDisplayMessageWhenBooDoesNotExist() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        UserAuthenticator userAuthenticator = mock(UserAuthenticator.class);

        ReturnMovie returnMovie = new ReturnMovie(userIO, library, userAuthenticator);
        when(userIO.inputLine()).thenReturn("Movie");
        when(library.getCheckedOutMovieByName("Movie")).thenReturn(Lendable.NO_LENDABLE);
        when(library.getAvailableMovieByName("Movie")).thenReturn(Lendable.NO_LENDABLE);

        returnMovie.run();

        verify(userIO).display("Sorry that movie does not exist!");
    }
}