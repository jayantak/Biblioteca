package biblioteca.library;

import biblioteca.io.UserIO;
import biblioteca.library.menuCommands.LibraryFunction;
import biblioteca.library.menuCommands.PrintInvalid;

import java.util.List;
import java.util.stream.Collectors;

//Understands the interactions with the user
public class Menu {

    private UserIO userIO;
    private List<LibraryFunction> commands;

    public Menu(UserIO userIO, List<LibraryFunction> commands) {
        this.userIO = userIO;
        this.commands = commands;
    }

    public void enter() {
        userIO.display("Welcome to Biblioteca!");
        mainMenu();
    }

    private void mainMenu() {
        boolean restart = true;

        List<String> menuItems = commands.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        while (restart) {
            LibraryFunction libraryFunction = getCommand(menuItems);
            restart = libraryFunction.run();
        }
    }

    private LibraryFunction getCommand(List<String> menuItems) {
        int choice = userIO.mainMenu(menuItems);
        LibraryFunction libraryFunction = commands.get(choice);
        if (libraryFunction == null) {
            libraryFunction = new PrintInvalid(userIO);
        }
        return libraryFunction;
    }
}
