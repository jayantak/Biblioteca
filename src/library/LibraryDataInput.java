package library;

import java.io.FileNotFoundException;

public interface LibraryDataInput {

    BookList getBookList() throws FileNotFoundException;
}
