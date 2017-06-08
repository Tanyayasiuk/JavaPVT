package javapvt.lesson7;

import java.util.Scanner;

public class Main implements OutputListener {

    public static void main(String[] args) {
        Main main = new Main();

        Bank bankomat = new Bank(6, 4, 1);
        bankomat.setListener(main);

        bankomat.printBalance();
        System.out.print("Выберите операцию:\n1. Внести деньги на счет \n2. Снять деньги со счета\n3. Завершить работу.\n: ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        while (choice < 1 || choice > 3){  // Тут еще exceptions учесть неплохо бы, но это позже)
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



    @Override
    public void onGetMoney(Bank bankomat,int result) {
        switch (result){
            case 0:
                System.out.println("Операция завершена успешно.");
                printBill(bankomat);
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
    public void onSetMoney(Bank bankomat, boolean result) {
        if (result == true) {
            System.out.println("Операция завершена успешно.");
            bankomat.printBalance();
        } else
            System.out.println("Ошибка.");
    }

    public void printBill (Bank bankomat){
        int[] bill = bankomat.getBill();
        System.out.println("Выдано " + bill[0] + " р. купюрами:\n" + bill[1] + " по 100 р.\n" + bill[2] + " по 50 р.\n" + bill[3] + " по 20 р.");
    }
}