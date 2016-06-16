package biblioteca.library;

import java.util.ArrayList;

//Understands manipulation of a set of books
public class BookList extends ArrayList<Book> {

    Book findBookByName(String booktitle) {
        for (Book book : this) {
            if (booktitle.equals(book.name)) {
                return book;
            }
        }
        return null;
    }

    void move(BookList other, Book book) {
        this.remove(book);
        other.add(book);
    }
}
