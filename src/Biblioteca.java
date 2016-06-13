import library.*;

import java.io.FileNotFoundException;

public class Biblioteca {

    public static void main(String[] args) throws FileNotFoundException {
        LibraryDataInput libraryDataInput = new TextFileDataInput("exampleLibrary");
        Library library = new Library(libraryDataInput.getBookList());
        LibraryIO libraryIO = new ConsoleIO(library);

        libraryIO.welcomeMessage();

        libraryIO.printBookList();
    }
}
