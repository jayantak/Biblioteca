package biblioteca.io;

import biblioteca.library.BookList;

import java.util.List;

public interface UserIO {

    void display(String s);

    void printBookList(BookList bookList, String format);

    int mainMenu(List<String> menuItems);

    void invalidOption();

    String inputBookTitle();
}
