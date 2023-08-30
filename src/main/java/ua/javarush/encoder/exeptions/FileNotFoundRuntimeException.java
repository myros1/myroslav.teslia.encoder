package ua.javarush.encoder.exeptions;

public class FileNotFoundRuntimeException extends RuntimeException {
    public FileNotFoundRuntimeException(Exception exception, String message) {
        super(exception);
        System.out.println(message);
    }
}
