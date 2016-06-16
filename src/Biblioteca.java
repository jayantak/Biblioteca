import biblioteca.io.ConsoleIO;
import biblioteca.io.LibraryDataInput;
import biblioteca.io.LibraryTextFileDataInput;
import biblioteca.io.UserIO;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.Menu;
import biblioteca.library.menuCommands.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    public static void main(String[] args) throws FileNotFoundException {
        String pathname = System.getProperty("user.dir") + "/exampleLibrary/libraryInventory.books";
        BufferedReader bookPropertiesReader = new BufferedReader(new FileReader(pathname));
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        LibraryDataInput libraryDataInput = new LibraryTextFileDataInput(bookPropertiesReader);
        UserIO userIO = new ConsoleIO(consoleInput);
        Library library = new Library(libraryDataInput.getBookList(), new LendableList());

        List<LibraryFunction> options = new ArrayList<>();

        options.add(new Exit());
        options.add(new ListBooks(userIO, library));
        options.add(new CheckoutBook(userIO, library));
        options.add(new ReturnBook(userIO, library));
        options.add(new ListMovies(userIO, library));

        Menu menu = new Menu(userIO, options);

        menu.enter();
    }
}
