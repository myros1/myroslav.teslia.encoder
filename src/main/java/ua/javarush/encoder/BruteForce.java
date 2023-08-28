package ua.javarush.encoder;

import java.util.ArrayList;
import java.util.HashMap;

public class BruteForce {
    ArrayList<Character> alphabet;

    public BruteForce(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public HashMap<Character, Integer> findRepeatSymbols(ArrayList<String> text) {
        HashMap<Character, Integer> quantityEachSymbol = new HashMap<>();
        int count = 0;
        for (String line : text) {
            StringBuffer bufferFromLine = new StringBuffer(line.toLowerCase());
            for (int i = 0; i < alphabet.size(); i++) {
                for (int j = 0; j < bufferFromLine.length(); j++) {
                    if (bufferFromLine.charAt(j) == alphabet.get(i)) {
                        count++;
                        bufferFromLine.deleteCharAt(j);
                        j--;
                    }
                }
                quantityEachSymbol.put(alphabet.get(i), count);
                count = 0;
            }
        }
        return quantityEachSymbol;
    }

    public Character findMostRepetitiveSymbol(HashMap<Character, Integer> map) {
        int max = 0;
        char symbol = 0;
        for (char temp : map.keySet()) {
            if (max < map.get(temp)) {
                max = map.get(temp);
                symbol = temp;
            }
        }
        return symbol;
    }

    public Integer getBruteForceKey(char symbol, char example) {
        int exampleKey = 0;
        for (int i = 0; i < alphabet.size(); i++) {
            if (example == alphabet.get(i)) {
                exampleKey = i;
            }
        }
        for (int i = 0; i < alphabet.size(); i++) {
            if (symbol == alphabet.get(i)) {
                if ((i - exampleKey) < 0) {
                    return alphabet.size() + i - exampleKey;
                }
            }
        }
        return null;
    }

    public void chooseBestKey(char symbol,ArrayList<String> reedList,BruteForce bruteForce) {
        ConsoleService consoleService = new ConsoleService();
        CaesarCipher caesarCipher = new AlphabetSwitcher().getCipher(reedList);
        char[] exampleSymbols = new char[]{' ', 'e', 't', 'a', 'o'};
        int keyBruteForce;
        for (int i = 0; i < 4; i++) {
            keyBruteForce = bruteForce.getBruteForceKey(symbol, exampleSymbols[i]);
            consoleService.print((i+1) + " case for key = " + keyBruteForce);
            for (String string : reedList) {
                consoleService.print(caesarCipher.crypt(string, keyBruteForce, "DECRYPT"));
            }
            consoleService.print("OKAY? yes/no");
            if (consoleService.read().equals("yes")) {
                break;
            }
        }
    }
}


