package biblioteca.library;

public class Movie implements Lendable {

    final String name;
    final String director;
    final int year;
    final int rating;

    public Movie(String name, String director, int year, int rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString(String format) {
        return String.format(format, name, director, Integer.toString(year), Integer.toString(rating));
    }

    @Override
    public boolean hasSameName(String otherName) {
        return this.name.equals(otherName);
    }
}
