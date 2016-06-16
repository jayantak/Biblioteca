package biblioteca.library;

import biblioteca.io.UserIO;

import java.util.Arrays;
import java.util.List;

public class Menu {

    UserIO userIO;
    Library library;

    public Menu(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    public void enter() {
        userIO.display("Welcome to Biblioteca!");
        mainMenu();
    }

    private void mainMenu() {
        boolean restart = true;
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book", "Return Book");
        while (restart) {
            int choice = userIO.mainMenu(menuItems);
            restart = library.execute(choice);
        }
    }
}
