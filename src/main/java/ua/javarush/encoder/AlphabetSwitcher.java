package ua.javarush.encoder;

import java.util.ArrayList;

public class AlphabetSwitcher {
    ArrayList<Character> eng = new Alphabets().ENGLISH_ALPHABET;
    ArrayList<Character> ukr = new Alphabets().UKRAINIAN_ALPHABET;

    public CaesarCipher getCipher(ArrayList<String> text) {
        for (String line : text) {
            for (int i = 0; i < line.length(); i++) {
                Character ch = line.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    if (eng.contains(ch)) {
                        return new CaesarCipher(eng);
                    } else if (ukr.contains(ch)) {
                        return new CaesarCipher(ukr);
                    }
                }
            }
        }
        return null;
    }

   public BruteForce getAlphabet(ArrayList<String> text) {
        for (String line : text) {
            for (int i = 0; i < line.length(); i++) {
                Character ch = line.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    if (eng.contains(ch)) {
                        return new BruteForce(eng);
                    } else if (ukr.contains(ch)) {
                        return new BruteForce(ukr);
                    }
                }
            }
        }return null;
    }
}