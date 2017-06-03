package javapvt.lesson6;

import java.util.Scanner;


public class Triangle extends Figure{
    private int height, base;

    public Triangle(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите высоту треугольника: ");
        this.height = scan.nextInt();
        System.out.print("Введите длину основания треугольника: ");
        this.base = scan.nextInt();
    }

    @Override
    public double getSquare(){
        return height * base * 0.5;
    }

}