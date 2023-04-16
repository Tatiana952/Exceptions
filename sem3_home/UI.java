package sem3_home;

import sem3_home.Exceptions.EmptyDataException;
import sem3_home.Exceptions.ModeException;

import java.util.*;

public class UI {
    Scanner scan = new Scanner(System.in);
    private static boolean follow = true;
    public boolean isFollow() {
        return follow;
    }

    public void changeFollow() {
        if(follow) follow = false;
        else follow = true;
    }

    /**
     * Print conditions of input.
     * @param i variant of conditions
     */
    public void conditions(int i){
        if (i == 2){
            System.out.print("\nPlease, enter data separated by spaces:\n" +
                    "1. Full Name\n" +
                    "2. Date of birth in format dd.mm.yyyy\n" +
                    "3. Phone number - unsigned integer without formatting\n" +
                    "4. Gender - f or m\n" +
                    "For exit enter 'X'\n" +
                    "Input: ");
        } else if (i == 1) {
            System.out.print("\nPlease, choose format for save:\n" +
                    "1. JSON\n" +
                    "2. TXT\n" +
                    "Input mode number: ");
        }
    }

    /**
     * Function for user input. User enter data separated by spaces and function split this line.
     * @return List of input words
     * @throws EmptyDataException appears if input string is empty
     */
    public List<String> readData() throws EmptyDataException {
        List<String> res = null;
        String data = scan.nextLine();
        if (data.equals("")){
            throw new EmptyDataException("Empty line entered!\n");
        } else {
             res = Arrays.asList(data.split("\\s+"));
        }
        return res;
    }

    /**
     * Function for choosing save method and format. There are two variants: JSON or TXT.
     * @return number of method in byte format
     * @throws ModeException appears if input is illegal number
     * @throws EmptyDataException appears if input string is empty
     */
    public byte chooseFormat() throws ModeException, EmptyDataException {
        String mode = scan.nextLine();
        if (mode.equals("")){
            throw new EmptyDataException("Empty line entered!\n");
        } else if (!mode.equals("1") && !mode.equals("2")) {
            throw new ModeException("\nIllegal number of mode. Try again!\n");
        } else {
            changeFollow();
            return Byte.parseByte(mode);
        }
    }

}

