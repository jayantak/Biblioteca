package library;

import java.io.FileNotFoundException;

public interface LibraryIO {

    void welcomeMessage(String s);

    void printBookList(BookList bookList, String format) throws FileNotFoundException;

    int mainMenu() throws FileNotFoundException;

    void invalidOption();
}
