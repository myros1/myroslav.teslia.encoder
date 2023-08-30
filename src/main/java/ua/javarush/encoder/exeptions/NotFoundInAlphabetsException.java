package ua.javarush.encoder.exeptions;

public class NotFoundInAlphabetsException extends RuntimeException{
    public NotFoundInAlphabetsException(String message){
        super(message);
    }
}