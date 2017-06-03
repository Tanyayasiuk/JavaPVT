package javapvt.lesson6;

import java.util.Scanner;

public class Square extends Figure {
    private int a;


    public Square(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите длину стороны квадрата: ");
        this.a = scan.nextInt();
    }

    @Override
    public double getSquare(){
        return Math.pow(a, 2);
    }


}