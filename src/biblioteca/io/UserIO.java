package biblioteca.io;

import biblioteca.library.Lendable;
import biblioteca.library.LendableList;

import java.util.List;

public interface UserIO {

    void display(String s);

    void printList(LendableList lendableList, Lendable lendableType, String format);

    int mainMenu(List<String> menuItems);

    void invalidOption();

    String inputBookTitle();
}
