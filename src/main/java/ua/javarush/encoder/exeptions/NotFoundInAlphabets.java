package ua.javarush.encoder.exeptions;

public class NotFoundInAlphabets extends RuntimeException{
    public NotFoundInAlphabets(String message){
        super(message);
    }
}