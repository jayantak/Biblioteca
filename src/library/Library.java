package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Library {

    public String bookList() throws FileNotFoundException {
        String pathname = System.getProperty("user.dir") + "/exampleData" + "/libraryInventory.books";
        File file = new File(pathname);
        Scanner scanner = new Scanner(file).useDelimiter("\\Z");
        return scanner.next();
    }
}
