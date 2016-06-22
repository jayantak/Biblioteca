package biblioteca.library;

import biblioteca.library.lendableItems.Book;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.lendableItems.Movie;
import biblioteca.library.user.User;
import biblioteca.library.user.UserAuthenticator;

//Understands lending and returning of books
public class Library {

    private LendableList inventory;
    private UserAuthenticator userAuthenticator;

    public Library(LendableList inventory, UserAuthenticator userAuthenticator) {
        this.inventory = inventory;
        this.userAuthenticator = userAuthenticator;
    }

    public void checkoutLendable(Lendable foundLendable, User user) {
        inventory.replace(foundLendable, User.NO_USER, user);
    }

    public Lendable getAvailableBookByName(String bookTitle) {
        Lendable found = inventory.findByName(bookTitle, User.NO_USER);
        if (found.getClass() != Book.class) {
            return Lendable.NO_LENDABLE;
        }
        return found;
    }

    public void returnLendable(Lendable foundLendable, User user) {
        inventory.replace(foundLendable, user, User.NO_USER);
    }

    public Lendable getCheckedOutBookByName(String bookTitle) {
        Lendable found = inventory.findByName(bookTitle, userAuthenticator.getCurrentUser());
        if (found.getClass() != Book.class) {
            return Lendable.NO_LENDABLE;
        }
        return found;
    }

    public LendableList available() {
        return inventory;
    }

    public Lendable getCheckedOutMovieByName(String title) {
        Lendable found = inventory.findByName(title, User.NO_USER);
        if (found.getClass() != Movie.class) {
            return Lendable.NO_LENDABLE;
        }
        return found;
    }

    public Lendable getAvailableMovieByName(String bookTitle) {
        Lendable found = inventory.findByName(bookTitle, userAuthenticator.getCurrentUser());
        if (found.getClass() != Movie.class) {
            return Lendable.NO_LENDABLE;
        }
        return found;
    }
}
