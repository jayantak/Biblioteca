import library.BookList;
import library.Library;

import java.io.FileNotFoundException;

public class Biblioteca {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(welcomeMessage());

        Library library = Library.createLibrary("exampleLibrary");
        System.out.println("\nAvailable books : ");
        BookList bookList = library.bookList();
        System.out.println(bookList.print());
    }

    static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }
}
