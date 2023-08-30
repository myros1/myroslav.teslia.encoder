package ua.javarush.encoder;

import java.util.Scanner;

public class ConsoleService {
    public String read() {
        Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();

    }

    public void print(String message) {
        System.out.println(message);
    }
}
