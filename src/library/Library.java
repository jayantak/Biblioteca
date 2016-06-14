package library;

//Understands lending of books
public class Library {

    private BookList inventory;
    private LibraryIO libraryIO;

    public Library(BookList inventory, LibraryIO libraryIO) {
        this.inventory = inventory;
        this.libraryIO = libraryIO;
    }

    Library(BookList bookList) {
        this(bookList, new ConsoleIO());
    }

    BookList bookList() {
        return inventory;
    }

    public void mainMenu() {
        boolean restart = true;
        while (restart) {
            int choice = libraryIO.mainMenu();
            restart = execute(choice);
        }
    }

    private boolean execute(int choice) {
        if (choice == 1) {
            libraryIO.printBookList(inventory, "%30s %30s %30s\n");
            return true;
        }
        if(choice == 0) {
            return false;
        }
        libraryIO.invalidOption();
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        return inventory != null ? inventory.equals(library.inventory) : library.inventory == null;

    }

    @Override
    public String toString() {
        return "Library{" +
                "inventory=" + inventory +
                '}';
    }

    public void enter() {
        libraryIO.display("Welcome to Biblioteca!");
        mainMenu();
    }
}
