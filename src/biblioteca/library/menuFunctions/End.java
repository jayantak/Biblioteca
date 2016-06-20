package biblioteca.library.menuFunctions;

import biblioteca.io.UserIO;

public class End {

    private UserIO userIO;
    private String endMessage;

    public End(UserIO userIO, String endMessage) {
        this.userIO = userIO;
        this.endMessage = endMessage;
    }

    public End(UserIO userIO) {
        this(userIO, "");
    }

    public void print() {
        userIO.display(endMessage);
    }
}
