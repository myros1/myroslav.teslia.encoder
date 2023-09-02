package ua.javarush.encoder;

import java.util.ArrayList;

public class CaesarCipher {
    private final ArrayList<Character> alphabet;

    public CaesarCipher(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public String crypt(String text, int key, String command) {
        if (command.equals("DECRYPT")) {
            key = -key;
        }
        key = key % alphabet.size();
        int newKey;
        String cryptText = "";
        for (char c : text.toCharArray()) {
            if (alphabet.contains(c)) {
                int i = alphabet.indexOf(c);
                if (i + key < 0) {
                    newKey = i + key + alphabet.size();
                } else newKey = i + key;
                cryptText += alphabet.get(newKey % alphabet.size());
            } else {
                cryptText += c;
            }
        }
        return cryptText;
    }
}
