package ua.javarush.encoder;

public class FileNotFound extends RuntimeException {
    public FileNotFound() {
    super("File not found");
    }

}
