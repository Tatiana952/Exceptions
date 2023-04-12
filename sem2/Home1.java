import java.util.Scanner;

public class Home1 {
    //public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.printf("You entered: %f", readFloat());
    }
    static float readFloat(){
        Scanner lineScanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input float (delimiter - comma): ");
            String line = lineScanner.nextLine();
            Scanner scanner = new Scanner(line);
            float i;
            if (scanner.hasNextFloat()) {
                i = scanner.nextFloat();
                if (!scanner.hasNext() ) {
                    return i;
                }
            }
        }
    }
}
