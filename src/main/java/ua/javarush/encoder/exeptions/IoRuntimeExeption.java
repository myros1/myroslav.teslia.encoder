package ua.javarush.encoder.exeptions;

import java.io.IOException;

public class IoRuntimeExeption extends RuntimeException {
    public IoRuntimeExeption(IOException exception){
        System.out.println(exception);
    }
}