package sem3_home.Exceptions;

public class AmountOfDataException extends MyExceptions {
    protected int amount;
    public int getAmount(){
        return this.amount;
    };
    public AmountOfDataException(String message, int amount) {
        super(message);
        this.amount = amount;
    }

}




