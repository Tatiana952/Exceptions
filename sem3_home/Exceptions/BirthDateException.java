package sem3_home.Exceptions;

import java.util.regex.PatternSyntaxException;

public class BirthDateException extends MyExceptions {
    private String date;

    public BirthDateException(String message, String date) {
        super(message);
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
