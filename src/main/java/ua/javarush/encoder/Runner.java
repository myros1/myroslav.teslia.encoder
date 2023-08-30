package ua.javarush.encoder;

import ua.javarush.encoder.exeptions.NotFoundInAlphabetsException;
import ua.javarush.encoder.exeptions.UnknownCommandRuntimeException;
import java.util.ArrayList;
import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        String command = args[0];
        String path = args[1];
        int key = Integer.parseInt(args[2]);
        Commands commands = new Commands();
        command = commands.getCommand(command);
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
            bruteForce.chooseBestKey(symbol,reedList,bruteForce);
        } else {
            ArrayList<String> cryptText = new ArrayList<>();
            CaesarCipher caesarCipher = new AlphabetSwitcher().getCipher(reedList);
            if (caesarCipher == null) {
                throw new NotFoundInAlphabetsException("Not contain in alphabets");
            }
            for (String string : reedList) {
                cryptText.add(caesarCipher.crypt(string, key, command));
            }
            fileService.writeWithNewFileName(cryptText, path, command);
        }
    }
}
