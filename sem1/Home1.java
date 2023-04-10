package geek;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;

public class Home1 {
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("Task #1:");
        task1();
        System.out.println("______________________________________");
        System.out.println("Task #2:");
        task2();
    }

    /**
     * Решение задачи 1 из дз
     */
    public static void task1(){
        int[] a1 = generateArray();
        int[] a2 = generateArray();
        int[] res = subsArray(a1, a2);
        System.out.println("Array #1: " + Arrays.toString(a1));
        System.out.println("Array #2: " + Arrays.toString(a2));
        System.out.println("Result array: " + Arrays.toString(res));
    }
    /**
     * Генерация рандомного массива. Его длина от 1 до 4 элементов.
     * Массив заполняется рандомными цифрами от 0 до 9 включительно.
     * @return Заполненный массив
     */
    private static int[] generateArray(){
        int[] arr = new int[random.nextInt(4)+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2);
        }
        return arr;
    }

    /**
     * Метод возвращающий новый массив,
     * каждый элемент которого равен разности элементов двух заданных массивов в той же ячейке.
     * @param arr1 Первый массив, значения в ячейках являются уменьшаемыми
     * @param arr2 Второй массив, значения в ячейках являются вычитаемыми
     * @return Массив с результатами
     */
    private static int[] subsArray(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length){
            throw new RuntimeException("Размеры сгенерированных массивов отличаются! Вычитание невозможно!");
        }
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i] - arr2[i];
        }
        return res;
    }

    /**
     * Решение задачи 2 из дз
     */
    static void task2(){
        int[] a1 = generateArray();
        int[] a2 = generateArray();
        float[] res = divArray(a1, a2);
        System.out.println("Array #1: " + Arrays.toString(a1));
        System.out.println("Array #2: " + Arrays.toString(a2));
        System.out.println("Result array: " + Arrays.toString(res));
    }

    /**
     * Метод возвращающий новый массив,
     * каждый элемент которого равен частному элементов двух заданных массивов в той же ячейке.
     * @param arr1 Первый массив, значения в ячейках являются делимыми
     * @param arr2 Второй массив, значения в ячейках являются делителями
     * @return Массив с результатами
     */
    private static float[] divArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length){
            throw new RuntimeException("Размеры сгенерированных массивов отличаются! Деление невозможно!");
        }
        float[] res = new float[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0){
                throw new RuntimeException("Происходит деление на 0. Операция невозможна!");
            }
            res[i] =(float)arr1[i] / (float)arr2[i];
        }
        return res;
    }

}
