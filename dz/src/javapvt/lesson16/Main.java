package javapvt.lesson16;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        Scanner scan = new Scanner(System.in);
        System.out.println("Для начала введите \"start\"");

        if (scan.nextLine().equals("start")){
            thread1.start();
            thread2.start();
        }
    }


    public /*synchronized*/ static void print10(int iter, String name){
        System.out.print(name);
        for (int i = iter * 10; i < (iter * 10)+10; i++){
            System.out.print(" " + i);
        }
        System.out.println("\n");
    }
}