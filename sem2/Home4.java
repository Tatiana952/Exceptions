import java.util.Scanner;

public class Home4 {
    public static void main(String[] args) {
       try {
        input();

       }catch (EmptyException e){
           System.out.println(e.getMessage());
       }

    }

    static void input() throws EmptyException {
        Scanner lineScanner = new Scanner(System.in);
        System.out.print("Input something: ");
        String line = lineScanner.nextLine();
        if (line.equals("")){
            throw new EmptyException("Exception! Line is empty!");
        }
    }
}
class EmptyException extends Exception{
    public EmptyException(String message) {
        super(message);
    }
}
