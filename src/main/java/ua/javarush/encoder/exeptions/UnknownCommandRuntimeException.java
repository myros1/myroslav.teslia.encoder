package ua.javarush.encoder.exeptions;

public class UnknownCommandRuntimeException extends RuntimeException {
    public UnknownCommandRuntimeException(String message) {
        super(message);
    }
}