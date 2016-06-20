package biblioteca.library.menuOptions;

public class Continue implements MenuOption {

    public boolean accessRestricted() {
        return false;
    }

    @Override
    public boolean run() {
        return true;
    }
}
