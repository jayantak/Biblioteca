package biblioteca.library.menuFunctions;

import biblioteca.io.UserIO;

import java.util.List;

public class MenuInput {

    UserIO userIO;

    public MenuInput(UserIO userIO) {
        this.userIO = userIO;
    }

    public int choice(List<String> menuItems) {
        return userIO.menu(menuItems);
    }
}
