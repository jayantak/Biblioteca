package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Movie;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutMovieTest {

    @Test
    public void shouldDisplayMessageWhenMovieIsCheckedOut() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        CheckoutMovie checkoutMovie = new CheckoutMovie(userIO, library);
        Movie movie = mock(Movie.class);
        when(userIO.inputTitle()).thenReturn("Movie");
        when(library.getCheckedOutMovieByName("Movie")).thenReturn(movie);

        checkoutMovie.run();

        verify(userIO).display("Sorry that movie is checked out!");
    }

    @Test
    public void shouldDisplayMessageWhenBooDoesNotExist() {
        UserIO userIO = mock(UserIO.class);
        Library library = mock(Library.class);
        CheckoutMovie checkoutMovie = new CheckoutMovie(userIO, library);
        when(userIO.inputTitle()).thenReturn("Movie");
        when(library.getCheckedOutMovieByName("Movie")).thenReturn(null);
        when(library.getAvailableMovieByName("Movie")).thenReturn(null);

        checkoutMovie.run();

        verify(userIO).display("Sorry that movie does not exist!");
    }
}