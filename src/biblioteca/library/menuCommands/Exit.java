package biblioteca.library.menuCommands;

//Understands how to exit the menu
public class Exit implements LibraryFunction {

    @Override
    public boolean run() {
        return false;
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
