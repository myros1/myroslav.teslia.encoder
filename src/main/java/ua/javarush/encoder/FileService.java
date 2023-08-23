package ua.javarush.encoder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileService {
    public void write(ArrayList<String> text, String path, String command) {
        String fileName = "/[" + command + "]" + path.substring(path.lastIndexOf("/") + 1);      //Create new file name : [COMMAND]FileName
        String newPath = path.substring(0, path.lastIndexOf("/")) + fileName;                             //Create path in the same directory
        try (FileWriter fileWriter = new FileWriter(newPath)) {
            for (String list : text) {
                fileWriter.write(list);
            }
        } catch (IOException e) {
            throw new FileNotFound();
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

        }
        return text;
    }
}