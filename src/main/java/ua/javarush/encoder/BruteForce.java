package ua.javarush.encoder;

import java.util.ArrayList;
import java.util.HashMap;

public class BruteForce {
    private final ArrayList<Character> alphabet;

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
        int exampleKey = alphabet.indexOf(example);
        if ((alphabet.indexOf(symbol) - exampleKey) < 0) {
            return alphabet.size() + alphabet.indexOf(symbol) - exampleKey;
        } else return alphabet.indexOf(symbol) - exampleKey;

    }

    public void chooseBestKey(char symbol, ArrayList<String> reedList, BruteForce bruteForce) {
        ConsoleService consoleService = new ConsoleService();
        Alphabets alphabets = new Alphabets();
        CaesarCipher caesarCipher = new AlphabetSwitcher().getCipher(reedList);
        char[] exampleSymbols;
        if (bruteForce.getAlphabet().equals(alphabets.ENGLISH_ALPHABET)) {
            exampleSymbols = new char[]{' ', 'e', 't', 'a', 'o'};
        } else {
            exampleSymbols = new char[]{' ', 'о', 'н', 'а', 'и'};
        }

        int keyBruteForce;
        System.out.println("Next, I will find 5 keys for decryption");
        for (int i = 0; i < 4; i++) {
            keyBruteForce = bruteForce.getBruteForceKey(symbol, exampleSymbols[i]);
            consoleService.print((i + 1) + " key = " + keyBruteForce + "\n");
            for (String string : reedList) {
                consoleService.print(caesarCipher.crypt(string, keyBruteForce, "DECRYPT"));
            }
            consoleService.print("\nOKAY? yes/no ");
            if (consoleService.read().equals("yes")) {
                return;
            }
        }
    }

    public ArrayList<Character> getAlphabet() {
        return alphabet;
    }
}
