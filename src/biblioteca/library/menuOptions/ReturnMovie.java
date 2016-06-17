package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;

public class ReturnMovie implements MenuOption {

    private UserIO userIO;
    private Library library;

    public ReturnMovie(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    @Override
    public boolean run() {
        userIO.display("Enter title of movie to return: ");
        String bookTitle = userIO.inputTitle();
        Lendable foundBook = library.getAvailableMovieByName(bookTitle);
        if (foundBook != null) {
            userIO.display("That movie has not been checked out!");
            return true;
        }
        foundBook = library.getCheckedOutMovieByName(bookTitle);
        if (foundBook != null) {
            library.returnLendable(foundBook);
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
