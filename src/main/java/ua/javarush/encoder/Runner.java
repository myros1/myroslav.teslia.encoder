package ua.javarush.encoder;

import ua.javarush.encoder.exeptions.UnknownCommandRuntimeException;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        Commands commands = new Commands();
        String command;
        Path path;
        int key = 0;
        if (args.length > 0) {
            command = commands.getCommand(args[0]);
            path = Path.of(args[1]);
            key = Integer.parseInt(args[2]);
        } else {
            ConsoleService consoleService = new ConsoleService();
            consoleService.print("Please enter command \"d\" - DECRYPT, \"e\" - ENCRYPT, \"b\" - Brute force ");
            command = commands.getCommand(consoleService.read());
            if (command.equals("UNKNOWN_COMMAND")) {
                throw new UnknownCommandRuntimeException(command);
            }
            consoleService.print("Please enter path to file");
            path = Path.of(consoleService.read());
            if (command.equals("DECRYPT") || command.equals("ENCRYPT")) {
                consoleService.print("Please enter key for crypt");
                key = Integer.parseInt(consoleService.read());
            }
        }
        if (command.equals("UNKNOWN_COMMAND")) {
            throw new UnknownCommandRuntimeException(command);
        }
        FileService fileService = new FileService();
        ArrayList<String> reedList;
        reedList = fileService.reed(path);
        if (command.equals("BRUTE_FORCE")) {
            BruteForce bruteForce = new AlphabetSwitcher().getAlphabet(reedList);
            HashMap<Character, Integer> symbolsToNumber = bruteForce.findRepeatSymbols(reedList);
            char symbol = bruteForce.findMostRepetitiveSymbol(symbolsToNumber);
            bruteForce.chooseBestKey(symbol, reedList, bruteForce);
        } else {
            ArrayList<String> cryptText = new ArrayList<>();
            CaesarCipher caesarCipher = new AlphabetSwitcher().getCipher(reedList);
            for (String string : reedList) {
                cryptText.add(caesarCipher.crypt(string, key, command));
            }
            fileService.writeWithNewFileName(cryptText, path, command);
        }
    }
}
