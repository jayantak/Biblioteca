package biblioteca.io;

import biblioteca.library.Lendable;
import biblioteca.library.LendableList;

import java.io.BufferedReader;
import java.io.IOException;
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
    public void printList(LendableList lendableList, Lendable lendableType, String format) {
        System.out.println("\nAvailable books : ");
        for (Lendable lendable : lendableList) {
            if (lendable.getClass() != lendableType.getClass()) {
                continue;
            }
            System.out.println(lendable.toString("%30s %30s %30s\n"));
        }
    }

    @Override
    public int mainMenu(List<String> menuItems) {
        System.out.println("" +
                "Choose option: ");
        int i = 0;
        for (String item : menuItems) {
            System.out.println("\n" + i++ + ". " + item);
        }
        int option = -1;
        try {
            option = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("Something went wrong with the input");
        }
        return option;
    }

    @Override
    public void invalidOption() {
        System.out.println("Select a valid option!");
    }

    @Override
    public String inputBookTitle() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
