import biblioteca.io.ConsoleIO;
import biblioteca.io.LibraryDataInput;
import biblioteca.io.LibraryIO;
import biblioteca.io.LibraryTextFileDataInput;
import biblioteca.library.Library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Biblioteca {

    public static void main(String[] args) throws FileNotFoundException {
        String pathname = System.getProperty("user.dir") + "/exampleLibrary/libraryInventory.books";
        BufferedReader bookPropertiesReader = new BufferedReader(new FileReader(pathname));
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        LibraryDataInput libraryDataInput = new LibraryTextFileDataInput(bookPropertiesReader);
        LibraryIO libraryIO = new ConsoleIO(consoleInput);
        Library library = new Library(libraryDataInput.getBookList(), libraryIO);

        library.enter();
    }
}
