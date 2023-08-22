package ua.javarush.encoder;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Runner {
    public int key;


    public static void main(String[] args) {
        String path = "target/Test.txt";
        FileService fileService = new FileService();
        ArrayList<String> reedList= new ArrayList<>();
        reedList = fileService.reed(path);
        System.out.println(reedList);
    }






}


