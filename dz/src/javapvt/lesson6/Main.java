package javapvt.lesson6;

/**
 * Created by ОК on 02.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        Figure square = new Square();
        printSquare(square);

        Figure tri = new Triangle();
        printSquare(tri);

        Figure cir = new Circle();
        printSquare(cir);

        int[] array = {1,1,1,1,1,1,1,1,1,1};
        System.out.println(Arrays.toString(array));
        int[] bArray = new int[20];
        System.arraycopy(array, 0, bArray, 5, array.length);
        System.out.println(Arrays.toString(bArray));

    }

    public static void printSquare(Figure figure){
        System.out.println("Площадь фигуры: " + figure.getSquare());
    }

}
