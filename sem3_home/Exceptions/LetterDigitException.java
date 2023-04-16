package sem3_home.Exceptions;

public class LetterDigitException extends DataExceptions{
    private String s;
    public LetterDigitException(String message, String s) {
        super(message);
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
