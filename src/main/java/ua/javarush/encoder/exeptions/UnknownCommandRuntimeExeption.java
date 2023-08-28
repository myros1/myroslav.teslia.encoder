package ua.javarush.encoder.exeptions;

public class UnknownCommandRuntimeExeption extends RuntimeException {
    public UnknownCommandRuntimeExeption(String message) {
        super(message);
    }
}