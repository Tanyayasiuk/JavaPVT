package javapvt.dz10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        calc.firstNum = readNumber(sc, "Введите певрое число: ");

        System.out.print("Выберите операцию:\n1. Сложение\n2. Вычитание\n3. Умножение\n4. Деление\n: ");
        calc.operation = 0;
        while (calc.operation == 0){
            try {
                calc.operation = Integer.parseInt(sc.next());

                while (calc.operation < 1 || calc.operation > 4){
                    System.out.print("Пожалуйста, выберите номер операции от 1 до 4: ");
                    calc.operation = Integer.parseInt(sc.next());
                }
            } catch (Exception e) {
                System.out.print("Пожалуйста, вводите только числа от 1 до 4: ");
                calc.operation = 0;
            }
        }

        calc.secondNum = readNumber(sc, "Введите второе число: ");

        switch (calc.operation){
            case 1:
                calc.sum(calc.firstNum, calc.secondNum);
                break;
            case 2:
                calc.subtract(calc.firstNum, calc.secondNum);
                break;
            case 3:
                try {
                    calc.mult(calc.firstNum, calc.secondNum);
                } catch (MyException e){
                    e.getRussianMessage(2);
                }
                break;
            case 4:
                try{
                    calc.division(calc.firstNum, calc.secondNum);
                } catch (MyException e){
                    e.getRussianMessage(1);
                }
        }
    }

    public static int readNumber (Scanner scan, String message){
        int number;
        System.out.print(message);
        while (true){
            try {
                number = Integer.parseInt(scan.next());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, вводите только числа: ");
            }
        }
        return number;
    }
}