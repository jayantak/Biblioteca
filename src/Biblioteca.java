import library.Library;

import java.io.FileNotFoundException;

public class Biblioteca {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(welcomeMessage());
        Library library = new Library();
        System.out.println(library.bookList());
    }

    static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }
}
