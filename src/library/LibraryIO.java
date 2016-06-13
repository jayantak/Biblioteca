package library;

import java.io.FileNotFoundException;

public interface LibraryIO {

    void welcomeMessage();

    void printBookList() throws FileNotFoundException;

    boolean mainMenu() throws FileNotFoundException;
}
