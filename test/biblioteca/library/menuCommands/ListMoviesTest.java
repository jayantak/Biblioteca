package biblioteca.library.menuCommands;

import biblioteca.io.ConsoleIO;
import biblioteca.io.UserIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.Movie;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ListMoviesTest {

    @Test
    public void shouldPrintMovieList() {
        UserIO userIO = mock(ConsoleIO.class);
        Library library = mock(Library.class);
        LendableList items = mock(LendableList.class);
        Movie movie = mock(Movie.class);

        ListBooks listBooks = new ListBooks(userIO, library);

        when(library.available()).thenReturn(items);
        when(items.get(0)).thenReturn(movie);

        listBooks.run();

        verify(userIO).printList(items, "%50s %30s %15s %15s\n");
    }
}