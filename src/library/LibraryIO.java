package library;

import java.util.List;

public interface LibraryIO {

    void display(String s);

    void printBookList(BookList bookList, String format);

    int mainMenu(List<String> menuItems);

    void invalidOption();

    String inputBookTitle();
}
