package biblioteca.library;

import biblioteca.io.UserIO;

import java.util.Arrays;
import java.util.List;

//Understands the interactions with the user
public class Menu {

    UserIO userIO;
    Library library;

    public Menu(UserIO userIO, Library library) {
        this.userIO = userIO;
        this.library = library;
    }

    public void enter() {
        userIO.display("Welcome to Biblioteca!");
        mainMenu();
    }

    private void mainMenu() {
        boolean restart = true;
        List<String> menuItems = Arrays.asList("Exit", "List Books", "Checkout Book", "Return Book");
        while (restart) {
            int choice = userIO.mainMenu(menuItems);
            restart = execute(choice);
        }
    }

    boolean execute(int choice) {
        if (choice == 1) {
            userIO.printBookList(library.available(), "%50s %30s %15s\n");
            return true;
        }
        if (choice == 0) {
            return false;
        }
        if (choice == 2) {
            checkout();
            return true;
        }
        if (choice == 3) {
            returnBook();
            return true;
        }
        userIO.invalidOption();
        return true;
    }

    private void checkout() {
        userIO.display("Enter title of book to checkout: ");
        String bookTitle = userIO.inputBookTitle();
        Book foundBook = library.getCheckedOutBookByName(bookTitle);
        if (foundBook != null) {
            userIO.display("Sorry that book is checked out!");
            return;
        }
        foundBook = library.getAvailableBookByName(bookTitle);
        if (foundBook != null) {
            library.returnbook(foundBook);
            userIO.display("Thank you! Enjoy the book!");
            return;
        }
        userIO.display("Sorry that book does not exist!");
    }


    private void returnBook() {
        userIO.display("Enter title of book to return: ");
        String bookTitle = userIO.inputBookTitle();
        Book foundBook = library.getAvailableBookByName(bookTitle);
        if (foundBook != null) {
            userIO.display("That book has not been checked out!");
            return;
        }
        foundBook = library.getCheckedOutBookByName(bookTitle);
        if (foundBook != null) {
            library.checkoutBook(foundBook);
            userIO.display("Thank you for returning the book!");
        }
        userIO.display("Sorry that book does not exist!");
    }
}
