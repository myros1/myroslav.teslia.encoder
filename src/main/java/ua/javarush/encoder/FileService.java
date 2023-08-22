package ua.javarush.encoder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileService {
    public void write(ArrayList<String> text, String path) {
        Path paths = Paths.get(path);
        Path newPath = paths.getRoot();
        try (FileWriter fileWriter = new FileWriter(newPath)){

        }
            }

    public ArrayList<String> reed(String filePath) {
        ArrayList<String> text = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            int offset = 0;
            char[] buffer = new char[1000];
            while (fileReader.ready()) {
                int count = fileReader.read(buffer);
                text.add(String.valueOf(buffer, offset, count));
            }
        } catch (IOException e) {
            throw new FileNotFound();

        }return text;
    }
}