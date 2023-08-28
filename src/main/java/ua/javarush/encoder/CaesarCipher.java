package ua.javarush.encoder;

import java.util.ArrayList;

public class CaesarCipher {
    ArrayList<Character> alphabet;

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
        for (int i = 0; i < text.length(); i++) {
            if (alphabet.contains(text.charAt(i))) {
                for (int j = 0; j < alphabet.size(); j++) {
                    if (alphabet.get(j) == text.charAt(i)) {
                        if (j + key < 0) {
                            newKey = j + key + alphabet.size();
                        } else newKey = j + key;
                        cryptText += (alphabet.get((newKey) % alphabet.size()));
                    }
                }
            } else cryptText += text.charAt(i);
        }
        return cryptText;
    }
}

