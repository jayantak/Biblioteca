package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.UserAuthenticator;

public class ReturnMovie implements MenuOption {

    private UserIO userIO;
    private Library library;
    private UserAuthenticator userAuthenticator;

    public ReturnMovie(UserIO userIO, Library library, UserAuthenticator userAuthenticator) {
        this.userIO = userIO;
        this.library = library;
        this.userAuthenticator = userAuthenticator;
    }

    public boolean accessAvailable() {
        return userAuthenticator.loggedIn();
    }

    @Override
    public boolean run() {
        userIO.display("Enter title of movie to return: ");
        String bookTitle = userIO.inputLine();
        Lendable foundBook = library.getAvailableMovieByName(bookTitle);
        if (foundBook != Lendable.NO_LENDABLE) {
            userIO.display("You have not checked out that movie!");
            return true;
        }
        foundBook = library.getCheckedOutMovieByName(bookTitle);
        if (foundBook != Lendable.NO_LENDABLE) {
            library.returnLendable(foundBook, userAuthenticator.getCurrentUser());
            userIO.display("Thank you for returning the movie!");
            return true;
        }
        userIO.display("Sorry that movie does not exist!");
        return true;
    }

    @Override
    public String toString() {
        return "Return Movie";
    }
}
