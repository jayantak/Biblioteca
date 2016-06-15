package io;

import biblioteca.library.BookList;

import java.io.FileNotFoundException;

public interface LibraryDataInput {

    BookList getBookList() throws FileNotFoundException;
}
