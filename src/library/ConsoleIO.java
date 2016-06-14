package library;

import java.util.Scanner;

public class ConsoleIO implements LibraryIO {

    @Override
    public void display(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    @Override
    public void printBookList(BookList bookList, String format) {
        System.out.println("\nAvailable books : ");
        System.out.println(String.format(format, "Book Name", "Author", "Year of Publication"));
        for (Book book : bookList) {
            System.out.println(book.toString("%30s %30s %30s\n"));
        }
    }

    @Override
    public int mainMenu() {
        System.out.println("" +
                "Choose option: \n" +
                "0. Exit\n" +
                "1. List Books");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void invalidOption() {
        System.out.println("Select a valid option!");
    }
}
