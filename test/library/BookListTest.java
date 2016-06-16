package library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookListTest {

    @Test
    public void bookListShouldPrintAllBooksWithTwoCopiesOfSameBook() {
        BookList books = new BookList();

        Book book = new Book("Book Name", "Author Name", 1999);
        books.add(book);

        String expected = String.format("%30s %30s %15s\n%30s %30s %15s\n", "Book Name", "Author", "Year of Publication", "Book Name", "Author Name", "1999");

        assertEquals(expected, books.print("%30s %30s %15s\n"));
    }

    @Test
    public void bookListShouldPrintAllBooksWithTwoBooks() {
        BookList books = new BookList();

        Book book = new Book("Book Name", "Author Name", 1999);
        Book anotherBook = new Book("Another", "Author Name", 1999);
        books.add(book);
        books.add(anotherBook);

        String expected = String.format("%30s %30s %15s\n%30s %30s %15s\n%30s %30s %15s\n", "Book Name", "Author", "Year of Publication", "Book Name", "Author Name", "1999", "Another", "Author Name", "1999");


        assertEquals(expected, books.print("%30s %30s %15s\n"));
    }
}