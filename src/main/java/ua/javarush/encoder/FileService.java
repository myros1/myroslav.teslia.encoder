package ua.javarush.encoder;

import ua.javarush.encoder.exeptions.FileNotFoundRuntimeExeption;
import ua.javarush.encoder.exeptions.IoRuntimeExeption;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileService {
    public void write(ArrayList<String> text, String path, String command) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            for (String list : text) {
                fileWriter.write(list);
            }
        } catch (IOException e) {
            throw new IoRuntimeExeption(e);
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
        } catch (FileNotFoundException e) {
            throw new FileNotFoundRuntimeExeption(e, "File not found");
        } catch (IOException e) {
            throw new IoRuntimeExeption(e);
        }
        return text;
    }
}

class FileServiceWithNewFilename extends FileService {
    FileService fileService;

    public FileServiceWithNewFilename(FileService fileService) {
        this.fileService = fileService;
    }

    public void write(ArrayList<String> text, String path, String command) {
        String fileName = "/[" + command + "]" + path.substring(path.lastIndexOf("/") + 1);      //Create new file name : [COMMAND]FileName
        String newPath = path.substring(0, path.lastIndexOf("/")) + fileName;                             //Create path in the same directory
        try (FileWriter fileWriter = new FileWriter(newPath)) {
            for (String list : text) {
                fileWriter.write(list);
            }
        } catch (IOException e) {
            throw new IoRuntimeExeption(e);
        }
    }
}

