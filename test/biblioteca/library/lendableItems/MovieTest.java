package biblioteca.library.lendableItems;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    @Test
    public void movieShouldBeEqualToItself() {
        Movie movie = new Movie("Movie Name", "Author Name", 1999, 5);
        assertEquals(movie, movie);
    }

    @Test
    public void copyOfMovieShouldBeEqualToItself() {
        Movie movie = new Movie("Movie Name", "Author Name", 1999, 5);
        Movie copyOfMovie = new Movie("Movie Name", "Author Name", 1999, 5);
        assertEquals(movie, copyOfMovie);
    }

    @Test
    public void displayShouldShowData() {
        Movie movie = new Movie("Movie Name", "Author Name", 1999, 5);
        assertEquals(String.format("%30s %30s %15s %15s\n", "Movie Name", "Author Name", "1999", "5"), movie.toString("%30s %30s %15s %15s\n"));
    }

    @Test
    public void movieShouldCheckSameName() {
        Movie movie = new Movie("Movie Name", "Author Name", 1999, 5);
        assertTrue(movie.hasSameName("Movie Name"));
    }

    @Test
    public void wrongMovieNameShouldGiveFalse() {
        Movie movie = new Movie("Movie Name", "Author Name", 1999, 5);
        assertFalse(movie.hasSameName("SomethingElse"));
    }
}