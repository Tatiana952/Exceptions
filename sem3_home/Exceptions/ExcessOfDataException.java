package sem3_home.Exceptions;

public class ExcessOfDataException extends AmountOfDataException{
    public ExcessOfDataException(String message, int amount) {
        super(message, amount);
    }
}