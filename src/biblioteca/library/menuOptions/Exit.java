package biblioteca.library.menuOptions;

//Understands how to exit the menu
public class Exit implements MenuOption {

    @Override
    public boolean run() {
        return false;
    }

    public boolean accessRestricted() {
        return true;
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
