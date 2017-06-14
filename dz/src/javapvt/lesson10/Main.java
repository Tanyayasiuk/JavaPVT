package javapvt.lesson10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите певрое число: ");
        boolean isOk = false;

        while (!isOk){
            try {
                calc.firstNum = Integer.parseInt(sc.next());
                isOk = true;
            } catch (Exception e) {
                System.out.print("Пожалуйста, вводите только числа: ");
                isOk = false;
            }
        }

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

        System.out.print("Введите второе число: ");
        isOk = false;
        while (!isOk){
            try {
                calc.secondNum = Integer.parseInt(sc.next());
                isOk = true;
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, вводите только числа: ");
                isOk = false;
            }
        }

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
}