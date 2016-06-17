import biblioteca.io.*;
import biblioteca.library.LendableList;
import biblioteca.library.Library;
import biblioteca.library.menuFunctions.MenuInput;
import biblioteca.library.menuFunctions.Start;
import biblioteca.library.menuOptions.*;
import biblioteca.library.user.User;
import biblioteca.library.user.UserAuthenticator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Biblioteca {

    private String libraryName;

    Biblioteca(String libraryName) {
        this.libraryName = libraryName;
    }

    void start() throws FileNotFoundException {
        Library library = createLibrary();

        UserIO userIO = createUserIO();
        UserAuthenticator userAuthenticator = createUserAuthenticator();

        Menu menu = createMenu(userIO, library, userAuthenticator);

        menu.run();
    }

    private UserAuthenticator createUserAuthenticator() throws FileNotFoundException {
        List<User> userList = new ArrayList<>();
        String pathname = System.getProperty("user.dir") + libraryName + "libraryMembers.users";
        BufferedReader userDataReader = new BufferedReader(new FileReader(pathname));
        LibraryTextFileUsersInput libraryTextFileUsersInput = new LibraryTextFileUsersInput(userDataReader);
        return new UserAuthenticator(libraryTextFileUsersInput.getUserList());
    }

    private UserIO createUserIO() {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        return new ConsoleIO(consoleInput);
    }

    private Library createLibrary() throws FileNotFoundException {
        String pathname = System.getProperty("user.dir") + libraryName + "libraryInventory.items";
        BufferedReader bookPropertiesReader = new BufferedReader(new FileReader(pathname));
        LibraryDataInput libraryDataInput = new LibraryTextFileItemsInput(bookPropertiesReader);

        return new Library(libraryDataInput.getBookList(), new LendableList());
    }

    private Menu createMenu(UserIO userIO, Library library, UserAuthenticator userAuthenticator) {

        Start start = new Start(userIO, "Welcome to Biblioteca!");
        MenuInput menuInput = new MenuInput(userIO);
        List<MenuOption> options = new ArrayList<>();
        options.add(new Exit());
        options.add(new Login(userIO, userAuthenticator));
        options.add(new ListBooks(userIO, library));
        options.add(new ListMovies(userIO, library));
        options.add(new CheckoutBook(userIO, library, userAuthenticator));
        options.add(new ReturnBook(userIO, library, userAuthenticator));
        options.add(new CheckoutMovie(userIO, library, userAuthenticator));
        options.add(new ReturnMovie(userIO, library, userAuthenticator));
        MenuOption invalid = new PrintInvalid(userIO);

        return new Menu(start, menuInput, options, invalid, "Main Menu");
    }

}
