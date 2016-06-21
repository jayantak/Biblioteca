package biblioteca;

import biblioteca.io.*;
import biblioteca.library.Library;
import biblioteca.library.menuFunctions.MenuInput;
import biblioteca.library.menuFunctions.Start;
import biblioteca.library.menuOptions.*;
import biblioteca.library.user.UserAuthenticator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Understands the options to show to the user
public class Biblioteca {

    private String libraryName;

    public Biblioteca(String libraryName) {
        this.libraryName = libraryName;
    }

    public void start() throws FileNotFoundException {

        UserIO userIO = createUserIO();
        UserAuthenticator userAuthenticator = createUserAuthenticator();
        Library library = createLibrary(userAuthenticator);

        Menu mainMenu = createMainMenu(userIO, library, userAuthenticator);

        mainMenu.run();
    }

    private UserAuthenticator createUserAuthenticator() throws FileNotFoundException {
        String pathname = System.getProperty("user.dir") + libraryName + "libraryMembers.users";
        BufferedReader userDataReader = new BufferedReader(new FileReader(pathname));
        LibraryTextFileUsersInput libraryTextFileUsersInput = new LibraryTextFileUsersInput(userDataReader);
        return new UserAuthenticator(libraryTextFileUsersInput.getUserList());
    }

    private UserIO createUserIO() {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        return new ConsoleIO(consoleInput);
    }

    private Library createLibrary(UserAuthenticator userAuthenticator) throws FileNotFoundException {
        String pathname = System.getProperty("user.dir") + libraryName + "libraryInventory.items";
        BufferedReader bookPropertiesReader = new BufferedReader(new FileReader(pathname));
        LibraryDataInput libraryDataInput = new LibraryTextFileItemsInput(bookPropertiesReader);

        return new Library(libraryDataInput.getBookList(), userAuthenticator);
    }

    private Menu createMainMenu(UserIO userIO, Library library, UserAuthenticator userAuthenticator) {

        MenuOption invalid = new PrintInvalid(userIO);
        MenuInput menuInput = new MenuInput(userIO);

        List<MenuOption> checkoutOptions = new ArrayList<>();
        checkoutOptions.add(new Exit());
        checkoutOptions.add(new CheckoutBook(userIO, library, userAuthenticator));
        checkoutOptions.add(new CheckoutMovie(userIO, library, userAuthenticator));
        Menu checkoutMenu = new Menu(new Start(userIO, "Checkout Item"), menuInput, checkoutOptions, invalid, "Checkout Item", true, userAuthenticator);

        List<MenuOption> returnOptions = new ArrayList<>();
        returnOptions.add(new Exit());
        returnOptions.add(new ReturnBook(userIO, library, userAuthenticator));
        returnOptions.add(new ReturnMovie(userIO, library, userAuthenticator));
        Menu returnMenu = new Menu(new Start(userIO, "Return Item"), menuInput, returnOptions, invalid, "Return Item", true, userAuthenticator);

        List<MenuOption> mainMenuOptions = new ArrayList<>();
        mainMenuOptions.add(new Exit());
        mainMenuOptions.add(new LogIn(userIO, userAuthenticator));
        mainMenuOptions.add(new LogOut(userAuthenticator));
        mainMenuOptions.add(new UserDetails(userIO, userAuthenticator));
        mainMenuOptions.add(new ListBooks(userIO, library));
        mainMenuOptions.add(new ListMovies(userIO, library));
        mainMenuOptions.add(checkoutMenu);
        mainMenuOptions.add(returnMenu);

        return new Menu(new Start(userIO, "Main Menu"), menuInput, mainMenuOptions, invalid, "Main Menu", false, userAuthenticator);
    }
}
