package library;

import java.util.ArrayList;

//Understands manipulation of a set of books
public class BookList extends ArrayList<Book> {

    public String print(String format) {
        String printedSolution = String.format(format, "Book Name", "Author", "Year of Publication");
        for (Book book : this) {
            printedSolution = printedSolution.concat(book.toString(format));
        }
        return printedSolution;
    }
}
