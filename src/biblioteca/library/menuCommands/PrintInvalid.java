package biblioteca.library.menuCommands;

import biblioteca.io.UserIO;

public class PrintInvalid implements LibraryFunction {

    private UserIO userIO;

    public PrintInvalid(UserIO userIO) {
        this.userIO = userIO;
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
