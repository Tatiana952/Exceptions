package sem3_home;

import sem3_home.Exceptions.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCheker {

    /**
     * Function for checking of amount of inputted data. Expected list with size = 6
     * @param s List with data
     * @throws LackOfDataException appears if size of list less than 6
     * @throws ExcessOfDataException appears if size of list more than 6
     */
    public void checkCountData(List<String> s) throws LackOfDataException, ExcessOfDataException {
        int expect = 6;
        int size = s.size();
        if (size < expect){
            throw new LackOfDataException("\nNot enough data entered. Expected 6 fields.", size);
        } else if (size > expect) {
            throw new ExcessOfDataException("\nToo much data entered. Expected 6 fields.", size);
        }
    }

    /**
     * Data validation function
     * @param s List with data
     */
    public void checkFields(List<String> s) {
        for (int i = 0; i < s.size(); i++) {
            try{
            isHasDigitsAndLetters(s.get(i));
            } catch (LetterDigitException e){
                System.err.printf("%s Your input: %s\n", e.getMessage(), e.getS());
            }
        }
        try{
            checkDateOfBirth(s.get(3));
            checkNumber(s.get(4));
            checkGender(s.get(5));
        } catch (BirthDateException e){
            System.err.printf("%s\n\n", e.getMessage());
        } catch (PhoneException e) {
            System.err.printf("%s Your input: %s\n\n", e.getMessage(), e.getNumber());
        } catch (GenderException e) {
            System.err.printf("%s Your input: %s\n\n", e.getMessage(), e.getGender());
        }
    }

    /**
     * String validation function
     * @param sPart String for validation
     * @throws LetterDigitException appears if string contains both letters and numbers
     */
    private void isHasDigitsAndLetters(String sPart) throws LetterDigitException {
        boolean hasDigits = false;
        boolean hasLettres = false;
        for (int i = 0; i < sPart.length() ; i++) {
            if(Character.isDigit(sPart.charAt(i))) hasDigits = true;
            if (Character.isLetter(sPart.charAt(i))) hasLettres = true;
        }
        if (hasLettres & hasDigits){
            throw new LetterDigitException("\nIllegal string format. It contains both letters and digits.", sPart);
        }
    }

    /**
     * Birthday validation function
     * @param sPart Birthday date in string format
     * @throws BirthDateException appears if format of date doesn't equal dd.mm.yyyy
     */
    private void checkDateOfBirth(String sPart) throws BirthDateException {
        final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)";
        final Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(sPart);
        if(!matcher.matches()) throw new BirthDateException("\nIllegal format of birthday date! Correct format: dd.mm.yyyy", sPart);;
    }

    /**
     * Gender validation function
     * @param sPart Gender in string format
     * @throws GenderException appears if string doesn't equal f or m
     */
    private void checkGender(String sPart) throws GenderException {
        if (!(sPart.toLowerCase().equals("f")) & !(sPart.toLowerCase().equals("m"))) { //
            throw new GenderException("\nIllegal gender! Expected 'f' or 'm'.", sPart);
        }
    }

    /**
     *  Phone number validation function
     * @param sPart Phone number ib string format
     * @throws PhoneException appears if number contains special signs or letters
     */
    private void checkNumber(String sPart) throws PhoneException {
        if(sPart.contains("+") | sPart.contains("-")){
            throw new PhoneException("\nIllegal phone number! '+' or '-' unacceptable.", sPart);
        }
        try{
        long number = Long.parseLong(sPart);
        }catch (NumberFormatException e){
            throw new PhoneException("\nIllegal format of phone number! Expected unsigned integer without formatting.", sPart);
        }
    }
}
