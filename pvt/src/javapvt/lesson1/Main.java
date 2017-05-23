package javapvt.lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Exercise #1
	    String str = "The weather is fine today, isn't it?";
        System.out.println("There're " + str.length() + " symbols in the string.");
        String newS1 = str.substring(0, str.length()/2);
        String newS2 = str.substring(str.length()/2);
        System.out.println("1st part: " + newS1);
        System.out.println("2nd part: " + newS2);

        // Exercise #2
        System.out.println("\nExercise #2\nPlease, enter the number: ");
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();

        if (d%10 == 7) {
            System.out.println("The last digit is 7.");
        } else {
            System.out.println("The last digit is NOT 7.");
        }

        //Exercise #3
        System.out.println("\nExercise #3:");
        int a, b, r;
        a = 4;
        b = 3;
        r = 3;
        double hypot = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        if (hypot <= 2 * r) {
            System.out.println("Yes, you can cover the rectangle with a circle.");
        } else {
            System.out.println("The rectangle is bigger.");
        }

        //Exercise #4
        System.out.println("\nExercise #4\nPlease, enter the amount: ");
        Scanner newscan = new Scanner(System.in);
        int number = newscan.nextInt();

        if (number >=11 && number <=14) {
            System.out.println(number + " рублей");
        } else if (number % 10 == 1){
            System.out.println(number + " рубль");
        } else if (number % 10 >= 2 && number % 10 <= 4){
            System.out.println(number + " рубля");
        } else {
            System.out.println(number + " рублей");
        }
        //Exercise #5
        System.out.println("\nExercise #5: ");
        String s5 = "Имеется строка, которая содержит символы ? и символы #.  Замените все символы ? на HELLO, а # - удалите. Результат вывести на экран";
        String newS51 = s5.replace("?", "HELLO");
        newS51 = newS51.replace("#", "");
        System.out.println(newS51);

        //Exercise #6
        System.out.println("\nExercise #6: ");
        int x = 1;
        int t, s;
        t = 1;
        s = 1;
        double y;
        y = Math.pow(Math.sin(Math.pow(x, t)), 2)/Math.sqrt(1 + Math.pow(x, s));
        System.out.println("y = " + y);
    }
}
