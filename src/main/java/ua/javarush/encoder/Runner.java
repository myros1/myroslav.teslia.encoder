package ua.javarush.encoder;


import java.util.ArrayList;

public class Runner {
    public int key;


    public static void main(String[] args) {
        String command = args[0];
        String pathNotUseNow = args[1];
        int key = Integer.parseInt(args[2]);
        String path = "target/[ENCRYPT]Test.txt";

        FileService fileService = new FileService();
        ArrayList<String> reedList = new ArrayList<>();
        reedList = fileService.reed(path);
        CaesarCipher caesarCipher = new CaesarCipher();
        ArrayList<String> cryptText = new ArrayList<>();

        for (String string:reedList) {
            cryptText.add(caesarCipher.crypt(string,key,command));
        }

        System.out.println(cryptText);
        fileService.write(cryptText, path, command);

    }


}


