package ua.javarush.encoder;

import ua.javarush.encoder.exeptions.FileNotFoundRuntimeException;
import ua.javarush.encoder.exeptions.IORuntimeException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileService {
    private final int LENGTH_BUFFER_REED_FILE = 1000;

    public void write(ArrayList<String> text, String path, String command) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            for (String list : text) {
                fileWriter.write(list);
            }
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

  public void writeWithNewFileName(ArrayList<String> text, Path path, String command) {
      String fileName = "/[" + command + "]" + path.getFileName();
      String newPath = path.getParent() + fileName;
      write(text, newPath, command);
    }

    public ArrayList<String> reed(Path filePath) {
        ArrayList<String> text = new ArrayList<>();
        try (FileReader fileReader = new FileReader(String.valueOf(filePath))) {
            int offset = 0;
            char[] buffer = new char[LENGTH_BUFFER_REED_FILE];
            while (fileReader.ready()) {
                int count = fileReader.read(buffer);
                text.add(String.valueOf(buffer, offset, count));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundRuntimeException(e, "File is not found");
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return text;
    }
}
