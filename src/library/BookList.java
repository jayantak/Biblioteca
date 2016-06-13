package library;

import java.io.FileNotFoundException;
import java.util.ArrayList;

//Understands manipulation of a set of books
public class BookList extends ArrayList<Book> {

    public String print() {
        String printedSolution = String.format("%30s %30s %15s", "Book Name" , "Author" , "Year of Publication");
        for (Book book : this) {
            printedSolution = printedSolution.concat(book.display());
            printedSolution = printedSolution.concat("\n");
        }
        return printedSolution;
    }
}
