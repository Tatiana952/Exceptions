package sem3_home.Exceptions;

public class PhoneException extends DataExceptions{
    private String number;
    public PhoneException(String message, String number) {
        super(message);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
