package library;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleIO implements LibraryIO {

    Library library;

    public ConsoleIO(Library library) {
        this.library = library;
    }

    @Override
    public void welcomeMessage() {
        System.out.println(library.welcomeMessage());
    }

    @Override
    public void printBookList() throws FileNotFoundException {
        System.out.println("\nAvailable books : ");
        System.out.println(library.bookList().print());
    }

    @Override
    public boolean mainMenu() throws FileNotFoundException {
        System.out.println("" +
                "Choose option: \n" +
                "1. List Books\n" +
                "2. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1) {
            printBookList();
            return false;
        }
        return true;
    }
}
