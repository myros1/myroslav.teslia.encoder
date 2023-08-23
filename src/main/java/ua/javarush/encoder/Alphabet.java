package ua.javarush.encoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
    public final ArrayList<Character> ENGLISH_ALPABET = getEnglishAlphabet();

    private ArrayList<Character> getEnglishAlphabet() {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 97; i < 123; i++) {
            list.add((char) i);
        }
        for (int i = 65; i < 91; i++) {
            list.add((char) i);
        }
        List<Character> subList = Arrays.asList('.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ');
        list.addAll(subList);
        return list;
    }

}
