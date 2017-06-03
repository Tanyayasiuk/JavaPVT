package javapvt.lesson6;

import java.util.Scanner;

public class Circle extends Figure {
    private int radius;

    public Circle(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите радиус круга: ");
        this.radius = scan.nextInt();
    }

    @Override
    public double getSquare(){
        return Math.PI * Math.pow(radius, 2);
    }

}