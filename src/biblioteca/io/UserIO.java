package biblioteca.io;

import biblioteca.library.LendableList;

import java.util.List;

public interface UserIO {

    void display(String s);

    void printList(LendableList lendableList, String format);

    int mainMenu(List<String> menuItems);

    void invalidOption();

    String inputBookTitle();
}
