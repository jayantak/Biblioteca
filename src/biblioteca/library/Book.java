package biblioteca.library;

//Understands the properties of a written novel
public class Book {

    final String name;
    final String author;
    final int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String toString(String format) {
        return String.format(format, name, author, Integer.toString(yearPublished));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (yearPublished != book.yearPublished) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}
