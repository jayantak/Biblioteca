package biblioteca.library.lendableItems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}