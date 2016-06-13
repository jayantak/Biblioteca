package library;

import java.io.FileNotFoundException;
import java.util.ArrayList;

//Understands manipulation of a set of books
public class BookList extends ArrayList<Book> {

    public String print() {
        String printedSolution = "";
        for (Book book : this) {
            printedSolution = printedSolution.concat(book.display());
            printedSolution = printedSolution.concat("\n");
        }
        return printedSolution;
    }

    void populateFrom(String path) throws FileNotFoundException {
        BookListInput bookListInput = new BookListInput(path);
        bookListInput.populateFrom(this);
    }


}
