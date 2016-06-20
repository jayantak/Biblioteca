import biblioteca.Biblioteca;

import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Biblioteca biblioteca = new Biblioteca("/exampleLibrary/");
        biblioteca.start();
    }
}
