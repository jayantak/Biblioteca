package biblioteca.library.menuOptions;

import biblioteca.io.UserIO;

public class PrintInvalid implements MenuOption {

    private UserIO userIO;

    public PrintInvalid(UserIO userIO) {
        this.userIO = userIO;
    }

    public boolean accessAvailable() {
        return true;
    }

    @Override
    public boolean run() {
        userIO.invalidOption();
        return true;
    }

    @Override
    public String toString() {
        return "Print Invalid";
    }
}
