package ua.javarush.encoder;

import ua.javarush.encoder.exeptions.NotFoundInAlphabetsException;
import java.util.ArrayList;

public class AlphabetSwitcher {
    ArrayList<Character> eng = new Alphabets().ENGLISH_ALPHABET;
    ArrayList<Character> ukr = new Alphabets().UKRAINIAN_ALPHABET;

    public CaesarCipher getCipher(ArrayList<String> text) throws NotFoundInAlphabetsException {
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
        throw new NotFoundInAlphabetsException("Could not find alphabet for text");
    }

    public BruteForce getAlphabet(ArrayList<String> text) throws NotFoundInAlphabetsException {
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
        }
        throw new NotFoundInAlphabetsException("Could not find alphabet for text");
    }
}
