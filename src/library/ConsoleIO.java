package library;

import java.io.FileNotFoundException;

public class ConsoleIO implements LibraryIO {

    Library library;

    public ConsoleIO(Library library) {
        this.library = library;
    }

    @Override
    public void welcomeMessage() {
        System.out.println(library.welcomeMessage());
    }

    @Override
    public void printBookList() throws FileNotFoundException {
        System.out.println("\nAvailable books : ");
        System.out.println(library.bookList().print());
    }
}
