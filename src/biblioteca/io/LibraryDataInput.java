package biblioteca.io;

import biblioteca.library.LendableList;

import java.io.FileNotFoundException;

public interface LibraryDataInput {

    LendableList getBookList() throws FileNotFoundException;
}
