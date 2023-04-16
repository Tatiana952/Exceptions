package sem3_home.Exceptions;

public class LackOfDataException extends AmountOfDataException{
    public LackOfDataException(String message, int amount) {
        super(message, amount);
    }
}
