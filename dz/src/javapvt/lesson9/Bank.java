package javapvt.dz9;

public class Bank {

    private int twenties;
    private int fifties;
    private int hundreds;
    private int amount;
    private int[] bill;

    public interface OutputListener {
        void onGetMoney(int result);
        void onSetMoney(boolean result);
    }


    private OutputListener listener;

    public void setListener(OutputListener listener) {
        this.listener = listener;
    }


    public Bank(int twenties, int fifties, int hundreds) {
        this.twenties = twenties;
        this.fifties = fifties;
        this.hundreds = hundreds;
        this.amount = this.twenties * 20 + this.fifties * 50 + this.hundreds * 100;
    }

    public int getAmount() { return amount;  }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTwenties() {
        return twenties;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public boolean isEnough (int needed, int having){
        return (having >= needed);
    }

    public int[] getBill() {
        return bill;
    }

    public void setBill(int sumI, int hd, int fft, int tw) {
        int[] bill = {sumI, hd, fft, tw};
        this.bill = bill;
    }

    public void addMoney(int twenties, int fifties, int hundreds) {
        int addition = twenties * 20 + fifties *50 + hundreds * 100;
        this.setTwenties(this.getTwenties() + twenties);
        this.setFifties(this.getFifties() + fifties);
        this.setHundreds(this.getHundreds() + hundreds);
        this.setAmount(this.getAmount() + addition);
        System.out.println("Внесено " + addition + " р.");
        listener.onSetMoney(true);
    }

    public void getMoney(int sum){
        int isSuccess;
        int sumI = sum;
        int[] startPos = new int[3];
        startPos[0] = this.getTwenties();
        startPos[1] = this.getFifties();
        startPos[2] = this.getHundreds();

        if (sum < 20 || sum % 10 != 0) {
            isSuccess = 1;
        } else if (sum == 30) {
            isSuccess = 3;
        } else if (sum > this.getAmount()) {
            isSuccess = 2;
        } else {
            int hd, fft = 0, tw = 0;                        // для подсчета необходимого кол-ва купюр

            hd = sum / 100;                             // разбираемся с сотнями
            if ((sumI % 100 / 10) % 2 != 0 && (sumI % 100) / 10 <= 3)
                hd--;
            if (!this.isEnough(hd, this.getHundreds()))
                hd = this.getHundreds();
            this.setHundreds(this.getHundreds() - hd);

            sum -= hd * 100;

            if (sum == 0) {
                this.setAmount(this.getAmount() - sum);
                setBill(sumI, hd, fft, tw);    // формирует чек - какие купюры и сколько были выданы
                isSuccess = 0;
            } else {
                fft = sum / 50;                             // черёд полтинников

                if ((sumI % 100 / 10) % 2 != 0 && this.getFifties() == 0) {
                    cancelOperation(startPos);
                    isSuccess = 3;
                } else if ((sumI % 100 / 10) % 2 == 0 && this.getFifties() < 2) {
                    fft = 0;
                } else {
                    if ((sumI % 100 / 10) % 2 != 0 && ((sumI % 100) / 10 <= 3) && this.isEnough(fft - 1, this.getFifties()))
                        fft--;

                    if (!this.isEnough(fft, this.getFifties()))
                        fft = this.getFifties();

                    if ((sumI % 100 / 10) % 2 == 0 && fft % 2 != 0)
                        fft--;
                    else if ((sumI % 100 / 10) % 2 != 0 && fft % 2 == 0)
                        fft--;
                    this.setFifties(this.getFifties() - fft);
                }

                sum -= fft * 50;
                tw = sum / 20;          // Теперь двадцатки.......................................................
                if (this.isEnough(tw, this.getTwenties())) {
                    this.setTwenties(this.getTwenties() - tw);
                    this.setAmount(this.getAmount() - sumI);
                    setBill(sumI, hd, fft, tw);
                    isSuccess = 0;
                } else {
                    cancelOperation(startPos);
                    isSuccess = 3;
                }
            }
        }
        listener.onGetMoney(isSuccess);
    }

    public void cancelOperation (int[] startPos){
        this.setTwenties(startPos[0]);
        this.setFifties(startPos[1]);
        this.setHundreds(startPos[2]);
    }

    public void printBalance() {
        System.out.println("В банкомате " + this.getAmount() + " р.");
    }

    public void printBill (){
        int[] bill = this.getBill();
        System.out.println("Выдано " + bill[0] + " р. купюрами:\n" + bill[1] + " по 100 р.\n" + bill[2] + " по 50 р.\n" + bill[3] + " по 20 р.");
    }

    /*public void printBanknotes(){
        System.out.println("В банкомате: ");
        System.out.println(this.getHundreds() + " купюр(-ы) по 100 р.");
        System.out.println(this.getFifties() + " купюр(-ы) по 50 р.");
        System.out.println(this.getTwenties() + " купюр(-ы) по 20 р.");

    }*/
}

