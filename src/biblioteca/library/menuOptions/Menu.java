package biblioteca.library.menuOptions;

import biblioteca.library.menuFunctions.MenuInput;
import biblioteca.library.menuFunctions.Start;

import java.util.List;
import java.util.stream.Collectors;

//Understands the interactions with the user
public class Menu implements MenuOption {

    private Start start;
    private List<MenuOption> options;
    private MenuOption invalid;
    private MenuInput input;
    private String menuTitle;

    public Menu(Start start, MenuInput input, List<MenuOption> options, MenuOption invalid, String menuTitle) {
        this.start = start;
        this.options = options;
        this.invalid = invalid;
        this.input = input;
        this.menuTitle = menuTitle;
    }

    public boolean accessAvailable() {
        return true;
    }

    @Override
    public boolean run() {
        start.print();
        mainMenu();
        return true;
    }

    private void mainMenu() {
        boolean restart = true;

        while (restart) {
            List<String> menuItems = options.stream()
                    .filter(MenuOption::accessAvailable)
                    .map(Object::toString)
                    .collect(Collectors.toList());
            MenuOption menuOption = getCommand(menuItems);
            restart = menuOption.run();
        }
    }

    private MenuOption getCommand(List<String> menuItems) {
        int choice = input.choice(menuItems);
        MenuOption menuOption;
        try {
            menuOption = options.get(choice);
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
