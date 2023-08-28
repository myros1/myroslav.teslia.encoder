package ua.javarush.encoder.exeptions;

import java.io.FileNotFoundException;

public class FileNotFoundRuntimeExeption extends RuntimeException {
    public FileNotFoundRuntimeExeption(FileNotFoundException e, String message) {
        super(message);
    }
}