package javapvt.dz2;

import java.util.Random;

/**
 * Created by ОК on 25.05.2017.
 */
public class Main {
    public static void main(String[] args) {

        //Exercise #1
        System.out.println("Exercise 1");
        int[] array = new int[10];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(20);
        }
        System.out.println("Initial array: ");

        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        int min = array[0];
        int max = array[0];

        //Looking for min value
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }

        //Looking for max value
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        System.out.println("The minimum value of the array is: " + min);
        System.out.println("The maximum value of the array is: " + max);

        //Changing min & max to 0 & 99
        System.out.print("\nThe new array: \n[ ");
        for (int i = 0; i < array.length; i++){
            if (array[i] == min) {
                array[i] = 0;
            } else if (array[i] == max){
                array[i] = 99;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("]\n");

        // Exercise #2
        //Все классно, если повторений 2, а если цифра встречается 3 и более раз - косяк - повторения считаются несколько раз(
        /*float[] arr = new float[10];
        Random rand1 = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.round(rand1.nextFloat(10));
        }
        System.out.println("The float array: ");

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");
        for (int i = 0; i < arr.length-1; i++){
            int dupl = 1;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] == arr[j])
                    dupl++;
            }
            if (dupl > 1)
                System.out.println("[" + arr[i] + "] - повторений " + dupl);
        }*/
        //попробую сначала отсортировать...


        //Exercise # 3
        int[] array1 = new int[10];
        System.out.println("Exercise 3\nNew random array: ");
        for (int i = 0; i < 10; i++) {
            array1[i] = (int) (Math.random() * 10);
            System.out.print(array1[i] + " ");
        }

        System.out.println("\nReversed:");

        int t;
        int m = array1.length - 1;

        for (int i = 0; i < (m - i); i++) {
            t = array1[i];
            array1[i] = array1[m - i];
            array1[m - i] = t;
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        //Exercise #4 - Sorting the previous array;
        System.out.println("\nSorted (for exercise 4): ");
        for (int i = array1.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array1[j] > array1[j + 1]) {
                    int temp = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Exercise 2: "); // The array should be float[] but I hope it doesn't really matter :)
        int dupl = 1;
        for (int i = 0; i < array1.length - 1; ) {
            int j = i + 1;
            for (; j < array1.length; ) {
                if (array1[i] == array1[j]) {
                    dupl++;
                    j++;
                } else
                    break;
            }
            if (dupl > 1)
                System.out.println("[" + array1[i] + "] - повторений " + dupl);
            dupl = 1;
            i = j;

        }
    }
}

