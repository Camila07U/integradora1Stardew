package Exceptions;

public class ChestNotFoundException extends RuntimeException {
    public ChestNotFoundException(String message) {
        super(message);
    }
}
