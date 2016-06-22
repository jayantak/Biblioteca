package biblioteca.library.lendableItems;

public class Movie implements Lendable {

    public static final Movie NO_MOVIE = new Movie("", "", 0, 0);

    private final String name;
    private final String director;
    private final int year;
    private final int rating;

    public Movie(String name, String director, int year, int rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String toString(String format) {
        return String.format(format, name, director, Integer.toString(year), Integer.toString(rating));
    }

    @Override
    public boolean hasSameName(String otherName) {
        return this.name.equals(otherName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (rating != movie.rating) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        return director != null ? director.equals(movie.director) : movie.director == null;

    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
