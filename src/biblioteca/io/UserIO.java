package biblioteca.io;

import biblioteca.library.LendableList;

import java.util.List;

public interface UserIO {

    void display(String s);

    void printList(LendableList lendableList, String format);

    int menu(List<String> menuItems);

    void invalidOption();

    String inputLine();

    void clear();
}
