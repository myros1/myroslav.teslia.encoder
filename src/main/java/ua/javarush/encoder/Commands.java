package ua.javarush.encoder;

public class Commands {
    private final String encrupt = "ENCRYPT";
    private final String decrupt = "DECRYPT";
     final String bruteForce = "BRUTE_FORCE";
    private final String unknownCommand = "UNKNOWN_COMMAND";

    public String getCommand(String command) {
        if (command.equalsIgnoreCase("d") || command.equalsIgnoreCase("decrupt")) {
            return decrupt;
        }
        if (command.equalsIgnoreCase("e") || command.equalsIgnoreCase("encrupt")) {
            return encrupt;
        }
        if (command.equalsIgnoreCase("b") || command.equalsIgnoreCase("brute_force")) {
            return bruteForce;
        }
        return unknownCommand;
    }

}