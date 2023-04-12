import java.util.Random;

public class Home2 {

    //    Семинар 2. Код к дз
    //    Задание 2
    static Random random = new Random();
    public static void main(String[] args) {
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(8)+1;
        }

        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

}
