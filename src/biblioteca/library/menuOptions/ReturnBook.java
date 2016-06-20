package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;
import biblioteca.library.user.UserAuthenticator;

//Understands how to return a book
public class ReturnBook implements MenuOption {

    private UserIO userIO;
    private Library library;
    private UserAuthenticator userAuthenticator;

    public ReturnBook(UserIO userIO, Library library, UserAuthenticator userAuthenticator) {
        this.userIO = userIO;
        this.library = library;
        this.userAuthenticator = userAuthenticator;
    }

    public boolean accessRestricted() {
        return userAuthenticator.loggedIn();
    }

    @Override
    public boolean run() {
        userIO.display("Enter title of book to return: ");
        String bookTitle = userIO.inputLine();
        Lendable foundBook = library.getAvailableBookByName(bookTitle);
        if (foundBook != Lendable.NO_LENDABLE) {
            userIO.display("You have not checked out that book!");
            return true;
        }
        foundBook = library.getCheckedOutBookByName(bookTitle);
        if (foundBook != Lendable.NO_LENDABLE) {
            library.returnLendable(foundBook, userAuthenticator.getCurrentUser());
            userIO.display("Thank you for returning the book!");
            return true;
        }
        userIO.display("Sorry that book does not exist!");
        return true;
    }

    @Override
    public String toString() {
        return "Return Book";
    }
}
