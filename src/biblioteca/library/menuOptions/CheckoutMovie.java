package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;

public class CheckoutMovie implements MenuOption {

    private UserIO userIO;
    private Library library;

    public CheckoutMovie(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    @Override
    public boolean run() {
        userIO.display("Enter title of movie to checkout: ");
        String title = userIO.inputTitle();
        Lendable foundMovie = library.getCheckedOutMovieByName(title);
        if (foundMovie != null) {
            userIO.display("Sorry that movie is checked out!");
            return true;
        }
        foundMovie = library.getAvailableMovieByName(title);
        if (foundMovie != null) {
            library.checkoutLendable(foundMovie);
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
