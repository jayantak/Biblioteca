import library.*;

import java.io.FileNotFoundException;

public class Biblioteca {

    public static void main(String[] args) throws FileNotFoundException {
        LibraryDataInput libraryDataInput = new TextFileDataInput("exampleLibrary");
        LibraryIO libraryIO = new ConsoleIO();
        Library library = new Library(libraryDataInput.getBookList(), libraryIO);

        library.welcomeMessage();
        boolean exit = false;
        while (!exit) {
            exit = library.mainMenu();
        }
    }
}
