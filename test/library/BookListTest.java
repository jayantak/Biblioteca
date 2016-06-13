package library;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void bookListShouldPrintAllBooksWithTwoCopiesOfSameBook() {
        BookList books = new BookList();

        Book book = new Book("Book Name", "Author Name", 1999);
        books.add(book);
        books.add(book);

        String expected = "Book Name\tAuthor Name\t1999\n" +
                "Book Name\tAuthor Name\t1999\n";

        assertEquals(expected, books.print());
    }

    @Test
    public void bookListShouldPrintAllBooksWithTwoBooks() {
        BookList books = new BookList();

        Book book = new Book("Book Name", "Author Name", 1999);
        Book anotherBook= new Book("Another", "Author Name", 1999);
        books.add(book);
        books.add(anotherBook);

        String expected = "Book Name\tAuthor Name\t1999\n" +
                "Another\tAuthor Name\t1999\n";

        assertEquals(expected, books.print());
    }
}