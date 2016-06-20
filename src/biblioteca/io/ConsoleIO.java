package biblioteca.io;

import biblioteca.library.LendableList;

import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;

//Understands user interactions on the console
public class ConsoleIO implements UserIO {

    private BufferedReader bufferedReader;

    public ConsoleIO(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void display(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

    @Override
    public void printList(LendableList lendableList, String format) {
        lendableList.forEach((lendable, user) -> System.out.println(lendable.toString(format)));
    }

    @Override
    public int menu(List<String> menuItems) {
        System.out.println("" +
                "Choose option: ");
        int i = 0;
        for (String item : menuItems) {
            System.out.println("" + i++ + ". " + item);
        }
        int option = -1;
        try {
            option = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            System.out.println("Something went wrong with the input, try again");
        }
        return option;
    }

    @Override
    public void invalidOption() {
        System.out.println("Select a valid option!");
    }

    @Override
    public String inputLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void clear() {
        System.out.flush();
    }
}
