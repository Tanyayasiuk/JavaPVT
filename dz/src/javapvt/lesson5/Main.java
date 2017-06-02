package javapvt.lesson5;

import java.util.Scanner;

// Надо еще добавить проверку, что в банкомате есть нужное количество купюр для выдачи, и отнимать выданные
// На выходных...

public class Main {
    public static void main(String[] args) {
        Bank bankomat = new Bank(2, 2, 4);
        printBalance(bankomat);
        printBanknotes(bankomat);
        addMoney(bankomat, 0, 1, 0);
        printBalance(bankomat);

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите сумму для снятия, кратную 10: ");
        getMoney(bankomat, scan.nextInt());

    }

    public static boolean addMoney(Bank bankomat, int twenties, int fifties, int hundreds) {
        int addition = twenties * 20 + fifties *50 + hundreds * 100;
        bankomat.setTwenties(bankomat.getTwenties() + twenties);
        bankomat.setFifties(bankomat.getFifties() + fifties);
        bankomat.setHundreds(bankomat.getHundreds() + hundreds);
        bankomat.setAmount(bankomat.getAmount() + addition);
        System.out.println("Внесено " + addition + " р.");
        return true;
    }


    public static void getMoney(Bank bankomat, int sum){
        int sumI = sum;
        if (sum < 20)
            System.out.println("Введите корректную сумму");
        else if (sum > bankomat.getAmount()) {
            System.out.println("Недостаточно средств");
        } else {
            int hd, fft = 0, tw = 0;
            if (sum%100 == 0)
                hd = sum / 100;
            else if ((sum % 100 / 10)%2 != 0){
                if ((sum % 100) / 10 <= 3){
                    hd = sum / 100 - 1;
                    sum -= hd * 100;
                    tw = sum / 20 - 2;
                    fft = (sum - tw * 20) / 50;
                } else if ((sum % 100) / 10 == 5){
                    hd = sum / 100;
                    sum -= hd * 100;
                    fft = sum / 50;
                } else {
                    hd = sum / 100;
                    fft = sum % 100 / 50;
                    tw = (sum%50)/20;
                }
            } else {
                hd = sum / 100;
                tw = sum % 100 / 20;
            }
            System.out.println("Выдано " + sumI + " р. купюрами:\n" + hd + " по 100 р.\n" + fft + " по 50 р.\n" + tw + " по 20 р.");
            bankomat.setAmount(bankomat.getAmount() - sumI);
            printBalance(bankomat);
        }

    }


    public static void printBalance(Bank bankomat) {
        System.out.println("В банкомате " + bankomat.getAmount() + " р.");
    }

    public static void printBanknotes(Bank bankomat){
        System.out.println("В банкомате: ");
        System.out.println(bankomat.getHundreds() + " купюр по 100 р.");
        System.out.println(bankomat.getFifties() + " купюр по 50 р.");
        System.out.println(bankomat.getTwenties() + " купюр по 20 р.");

    }

}

