package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;
import biblioteca.library.Library;
import biblioteca.library.lendableItems.Lendable;

//Understands how to return a book
public class ReturnBook implements MenuOption {

    private UserIO userIO;
    private Library library;

    public ReturnBook(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    @Override
    public boolean run() {
        userIO.display("Enter title of book to return: ");
        String bookTitle = userIO.inputTitle();
        Lendable foundBook = library.getAvailableBookByName(bookTitle);
        if (foundBook != null) {
            userIO.display("That book has not been checked out!");
            return true;
        }
        foundBook = library.getCheckedOutBookByName(bookTitle);
        if (foundBook != null) {
            library.returnLendable(foundBook);
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
