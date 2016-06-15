package io;

import biblioteca.library.Book;
import biblioteca.library.BookList;

import java.util.List;
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
    public int mainMenu(List<String> menuItems) {
        System.out.println("" +
                "Choose option: ");
        int i = 0;
        for (String item : menuItems) {
            System.out.println("\n" + i++ + ". " + item);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void invalidOption() {
        System.out.println("Select a valid option!");
    }

    @Override
    public String inputBookTitle() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
