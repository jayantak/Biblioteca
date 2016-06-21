package biblioteca.library.menuOptions;

import biblioteca.io.ConsoleIO;
import biblioteca.io.UserIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Movie;
import biblioteca.library.user.User;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListMoviesTest {

    @Test
    public void shouldPrintMovieList() {
        UserIO userIO = mock(ConsoleIO.class);
        Library library = mock(Library.class);
        LendableList items = new LendableList();
        Movie movie = new Movie("", "", 0, 0);
        items.put(movie, User.NO_USER);

        ListMovies listMovies = new ListMovies(userIO, library);

        when(library.available()).thenReturn(items);

        listMovies.run();

        verify(userIO).printList(items, "%50s %30s %15s %15s");
    }
}