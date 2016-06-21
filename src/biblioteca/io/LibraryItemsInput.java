package biblioteca.io;

import biblioteca.library.LendableList;

import java.io.FileNotFoundException;

public interface LibraryItemsInput {

    LendableList getItemList() throws FileNotFoundException;
}
