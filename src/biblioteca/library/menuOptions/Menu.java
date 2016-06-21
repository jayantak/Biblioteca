package biblioteca.library.menuOptions;

import biblioteca.library.menuFunctions.MenuInput;
import biblioteca.library.menuFunctions.Start;
import biblioteca.library.user.UserAuthenticator;

import java.util.List;
import java.util.stream.Collectors;

//Understands the interactions with the user
public class Menu implements MenuOption {

    private Start start;
    private List<MenuOption> options;
    private MenuOption invalid;
    private MenuInput input;
    private String menuTitle;
    private boolean requiresLogin;
    private UserAuthenticator userAuthenticator;

    public Menu(Start start, MenuInput input, List<MenuOption> options, MenuOption invalid, String menuTitle, boolean requiresLogin, UserAuthenticator userAuthenticator) {
        this.start = start;
        this.options = options;
        this.invalid = invalid;
        this.input = input;
        this.menuTitle = menuTitle;
        this.requiresLogin = requiresLogin;
        this.userAuthenticator = userAuthenticator;
    }

    public boolean accessAvailable() {
        if (requiresLogin) {
            return userAuthenticator.loggedIn();
        }
        return true;
    }

    @Override
    public boolean run() {
        boolean restart = true;

        while (restart) {
            start.print();
            List<MenuOption> validOptions = options.stream()
                    .filter(MenuOption::accessAvailable)
                    .collect(Collectors.toList());

            List<String> menuItems = validOptions.stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());

            MenuOption menuOption = getCommand(menuItems, validOptions);
            restart = menuOption.run();
        }
        return true;
    }

    private MenuOption getCommand(List<String> menuItems, List<MenuOption> validOptions) {
        int choice = input.choice(menuItems);
        MenuOption menuOption;
        try {
            menuOption = validOptions.get(choice);
        } catch (Exception e) {
            menuOption = invalid;
        }
        if (menuOption == null) {
            menuOption = invalid;
        }
        return menuOption;
    }

    @Override
    public String toString() {
        return menuTitle;
    }
}
