package ua.javarush.encoder;

import java.util.ArrayList;

public class CaesarCipher {


    public String crypt(String text, int key, String command) {
        if (command.equals("ENCRYPT")) {
            key = key;
        } else if (command.equals("DECRYPT")) {
            key = -key;
        }
        ArrayList<Character> latinAlphabet = new Alphabet().ENGLISH_ALPABET;
        key = key % latinAlphabet.size();                                       //Make short key if key > size of Alphabet
        int newKey;
        String cryptText = "";
        for (int i = 0; i < text.length(); i++) {
            if (latinAlphabet.contains(text.charAt(i))) {
                for (int j = 0; j < latinAlphabet.size(); j++) {
                    if (latinAlphabet.get(j) == text.charAt(i)) {
                        if (j + key < 0) {
                            newKey = j + key + latinAlphabet.size();
                        } else newKey = j + key;
                        cryptText += (latinAlphabet.get((newKey) % latinAlphabet.size()));
                    }
                }
            } else cryptText += text.charAt(i);
        }
        return cryptText;
    }
}




