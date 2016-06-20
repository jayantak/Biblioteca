package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.UserAuthenticator;

public class CheckoutMovie implements MenuOption {

    private UserIO userIO;
    private Library library;
    private UserAuthenticator userAuthenticator;

    public CheckoutMovie(UserIO userIO, Library library, UserAuthenticator userAuthenticator) {
        this.userIO = userIO;
        this.library = library;
        this.userAuthenticator = userAuthenticator;
    }

    public boolean accessRestricted() {
        return userAuthenticator.loggedIn();
    }

    @Override
    public boolean run() {
        userIO.display("Enter title of movie to checkout: ");
        String title = userIO.inputLine();
        Lendable foundMovie = library.getCheckedOutMovieByName(title);
        if (foundMovie != Lendable.NO_LENDABLE) {
            userIO.display("Sorry that movie is checked out!");
            return true;
        }
        foundMovie = library.getAvailableMovieByName(title);
        if (foundMovie != Lendable.NO_LENDABLE) {
            library.checkoutLendable(foundMovie, userAuthenticator.getCurrentUser());
            userIO.display("Thank you! Enjoy the movie!");
            return true;
        }
        userIO.display("Sorry that movie does not exist!");
        return true;
    }

    @Override
    public String toString() {
        return "Checkout Movie";
    }
}
