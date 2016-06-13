package library;

//Understands a single book
class Book {

    final String name;
    final String author;
    final int yearPublished;

    Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    static Book createBook(String bookData) {
        String[] metaData = bookData.split(",");
        return new Book(metaData[0], metaData[1], Integer.parseInt(metaData[2]));
    }

    String display() {
        return name + "\t" + author + "\t" + Integer.toString(yearPublished);
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
