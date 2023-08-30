package ua.javarush.encoder;

public class Commands {
    private final String encrypt = "ENCRYPT";
    private final String decrypt = "DECRYPT";
    private final String bruteForce = "BRUTE_FORCE";
    private final String unknownCommand = "UNKNOWN_COMMAND";

    public String getCommand(String command) {
        if (command.equalsIgnoreCase("d") || command.equalsIgnoreCase("decrypt")) {
            return decrypt;
        }
        if (command.equalsIgnoreCase("e") || command.equalsIgnoreCase("encrypt")) {
            return encrypt;
        }
        if (command.equalsIgnoreCase("b") || command.equalsIgnoreCase("brute_force")) {
            return bruteForce;
        }
        return unknownCommand;
    }

}
