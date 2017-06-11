package javapvt.lesson9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank bankomat = new Bank(6, 4, 1);
        bankomat.setListener(new Bank.OutputListener() {
            @Override
            public void onGetMoney(int result) {
                switch (result){
                    case 0:
                        System.out.println("Операция завершена успешно.");
                        bankomat.printBill();
                        break;
                    case 1:
                        System.out.println("Некорректная сумма.");
                        break;
                    case 2:
                        System.out.println("Недостаточно средств.");
                        break;
                    case 3:
                        System.out.println("Извините, выдача невозможна.");
                        break;
                }
            }

            @Override
            public void onSetMoney(boolean result) {
                if (result) {
                    System.out.println("Операция завершена успешно.");
                    bankomat.printBalance();
                } else
                    System.out.println("Ошибка.");
            }
        });

        bankomat.printBalance();
        System.out.print("Выберите операцию:\n1. Внести деньги на счет \n2. Снять деньги со счета\n3. Завершить работу.\n: ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        while (choice < 1 || choice > 3){
            System.out.println("Пожалуйста, выберите номер операции (1, 2 или 3).");
            choice = scan.nextInt();
        }

        if (choice == 3) {
            System.out.println("Обслуживание завершено.");
        } else if (choice == 1){
            System.out.print("Введите количество купюр наминалом 100 р.");
            int hundreds = scan.nextInt();
            System.out.print("Введите количество купюр наминалом 50 р.");
            int fifties = scan.nextInt();
            System.out.print("Введите количество купюр наминалом 20 р.");
            int twenties = scan.nextInt();
            bankomat.addMoney(twenties, fifties, hundreds);
        } else {
            System.out.print("Введите сумму для снятия (не менее 20 р., кратную 10): ");
            bankomat.getMoney(scan.nextInt());
        }
    }
}
