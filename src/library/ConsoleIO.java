package library;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleIO implements LibraryIO {

    @Override
    public void welcomeMessage(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    @Override
    public void printBookList(BookList bookList, String format) throws FileNotFoundException {
        System.out.println("\nAvailable books : ");
        System.out.println(String.format(format, "Book Name", "Author", "Year of Publication"));
        for (Book book : bookList) {
            System.out.println(book.toString("%30s %30s %30s\n"));
        }
    }

    @Override
    public int mainMenu() throws FileNotFoundException {
        System.out.println("" +
                "Choose option: \n" +
                "1. List Books\n" +
                "2. Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void invalidOption() {
        System.out.println("Select a valid option!");
    }
}
