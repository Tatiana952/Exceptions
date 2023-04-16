package sem3_home.Exceptions;

public class GenderException extends DataExceptions{

    private String gender;
    public GenderException(String message, String gender) {
        super(message);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
