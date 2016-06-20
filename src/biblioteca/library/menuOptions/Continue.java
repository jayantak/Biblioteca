package biblioteca.library.menuOptions;

public class Continue implements MenuOption {

    public boolean accessAvailable() {
        return false;
    }

    @Override
    public boolean run() {
        return true;
    }
}
