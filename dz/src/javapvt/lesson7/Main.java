package javapvt.lesson7;

import java.util.Scanner;

public class Main implements OutputListener {

    public static void main(String[] args) {
        Main main = new Main();

        Bank bankomat = new Bank(6, 4, 1);
        bankomat.setListener(main);

        bankomat.printBalance();

        //bankomat.addMoney(1, 1, 0);
        //bankomat.printBanknotes();

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите сумму для снятия (больше 20 р., кратную 10): ");

        int result = bankomat.getMoney(scan.nextInt());

        bankomat.OnMoneyGet(result);

        bankomat.printBalance();
        //bankomat.printBanknotes();

    }

    @Override
    public void onOutput(int result) {
        switch (result){
            case 0:
                System.out.println("Операция завершена успешно.");
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
}
