package javapvt.lesson5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bankomat = new Bank(10, 5, 0);

        printBalance(bankomat);

        addMoney(bankomat, 1, 1, 0);

        printBalance(bankomat);
        printBanknotes(bankomat);

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите сумму для снятия (больше 20 р., кратную 10): ");

        getMoney(bankomat, scan.nextInt());

        printBanknotes(bankomat);
        //printBalance(bankomat);

    }

    public static boolean addMoney(Bank bankomat, int twenties, int fifties, int hundreds) {
        int addition = twenties * 20 + fifties *50 + hundreds * 100;
        bankomat.setTwenties(bankomat.getTwenties() + twenties);
        bankomat.setFifties(bankomat.getFifties() + fifties);
        bankomat.setHundreds(bankomat.getHundreds() + hundreds);
        bankomat.setAmount(bankomat.getAmount() + addition);
        System.out.println("Внесено " + addition + " р.");
        printBalance(bankomat);
        return true;
    }


    public static boolean getMoney(Bank bankomat, int sum) {
        boolean isSuccess = false;
        int sumI = sum;
        int[] startPos = new int[3];
        startPos[0] = bankomat.getTwenties();
        startPos[1] = bankomat.getFifties();
        startPos[2] = bankomat.getHundreds();

        if (sum < 20 || sum % 10 != 0) {
            System.out.println("Введите корректную сумму");
            isSuccess = false;
        } else if (sum == 30) {
            cancelOperation(bankomat, startPos);
            isSuccess = false;
        } else if (sum > bankomat.getAmount()) {
            System.out.println("Недостаточно средств");
            isSuccess = false;
        } else {
            int hd, fft = 0, tw=0;                        // для подсчета необходимого кол-ва купюр

            hd = sum / 100;                             // разбираемся с сотнями
            if ((sumI % 100 / 10) % 2 != 0 && (sumI % 100) / 10 <= 3)
                hd--;
            if (!bankomat.isHuEnough(hd))
                hd = bankomat.getHundreds();
            bankomat.setHundreds(bankomat.getHundreds() - hd);

            sum -= hd * 100;

            if (sum == 0) {
                printBill(bankomat, sumI, hd, fft, tw);
                isSuccess = true;
            } else {
                fft = sum / 50;                             // черёд полтинников

                if ((sumI % 100 / 10) % 2 != 0 && bankomat.getFifties() == 0) {
                    cancelOperation(bankomat, startPos);
                    isSuccess = false;
                } else if ((sumI % 100 / 10) % 2 == 0 && bankomat.getFifties() < 2) {
                    fft = 0;
                } else {
                    if ((sumI % 100 / 10) % 2 != 0 && ((sumI % 100) / 10 <= 3) && bankomat.isFiEnough(fft - 1))
                        fft--;

                    if (!bankomat.isFiEnough(fft))
                        fft = bankomat.getFifties();

                    if ((sumI % 100 / 10) % 2 == 0 && fft % 2 != 0)
                        fft--;
                    else if ((sumI % 100 / 10) % 2 != 0 && fft % 2 == 0)
                        fft--;

                    bankomat.setFifties(bankomat.getFifties() - fft);
                }

                // Теперь двадцатки.......................................................
                sum -= fft * 50;
                tw = sum / 20;
                if (bankomat.isTwEnough(tw)) {
                    bankomat.setTwenties(bankomat.getTwenties() - tw);
                    printBill(bankomat, sumI, hd, fft, tw);
                    isSuccess = true;
                } else {
                    cancelOperation(bankomat, startPos);
                    isSuccess = false;
                }
            }
        }
        return isSuccess;
    }

    public static void printBalance(Bank bankomat) {
        System.out.println("В банкомате " + bankomat.getAmount() + " р.");
    }

    public static void printBanknotes(Bank bankomat){
        System.out.println("В банкомате: ");
        System.out.println(bankomat.getHundreds() + " купюр(-ы) по 100 р.");
        System.out.println(bankomat.getFifties() + " купюр(-ы) по 50 р.");
        System.out.println(bankomat.getTwenties() + " купюр(-ы) по 20 р.");
    }

    public static void printBill (Bank bankomat, int sum, int hd, int fft, int tw){
        System.out.println("Выдано " + sum + " р. купюрами:\n" + hd + " по 100 р.\n" + fft + " по 50 р.\n" + tw + " по 20 р.");
        bankomat.setAmount(bankomat.getAmount() - sum);
        printBalance(bankomat);
    }


    public static void cancelOperation (Bank bankomat, int[] startPos){
        System.out.println("Извините, выдача невозможна.");
        bankomat.setTwenties(startPos[0]);
        bankomat.setFifties(startPos[1]);
        bankomat.setHundreds(startPos[2]);
    }

}

