import io.ConsoleIO;
import io.LibraryDataInput;
import io.LibraryIO;
import io.LibraryTextFileDataInput;
import biblioteca.library.*;

import java.io.FileNotFoundException;

public class Biblioteca {

    public static void main(String[] args) throws FileNotFoundException {
        LibraryDataInput libraryDataInput = new LibraryTextFileDataInput("exampleLibrary");
        LibraryIO libraryIO = new ConsoleIO();
        Library library = new Library(libraryDataInput.getBookList(), libraryIO);

        library.enter();
    }
}
