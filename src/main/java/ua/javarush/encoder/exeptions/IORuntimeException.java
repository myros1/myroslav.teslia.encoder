package ua.javarush.encoder.exeptions;

import java.io.IOException;

public class IORuntimeException extends RuntimeException {
    public IORuntimeException(IOException exception) {
        super(exception);
    }
}
