package biblioteca.library.menuFunctions;

import biblioteca.io.UserIO;

public class Start {

    private UserIO userIO;
    private String welcomeMessage;

    public Start(UserIO userIO, String welcomeMessage) {
        this.userIO = userIO;
        this.welcomeMessage = welcomeMessage;
    }

    public void print() {
        userIO.display("----------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------\n" + welcomeMessage);
    }
}
