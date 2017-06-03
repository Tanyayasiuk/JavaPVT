package javapvt.lesson5;

public class Bank {

    private int twenties;
    private int fifties;
    private int hundreds;
    private int amount;

    public Bank(int twenties, int fifties, int hundreds) {
        this.twenties = twenties;
        this.fifties = fifties;
        this.hundreds = hundreds;
        this.amount = this.twenties * 20 + this.fifties * 50 + this.hundreds * 100;
    }

    public int getAmount() {
        return amount;
    }

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

    public boolean isHuEnough(int hdNeeded){
        return (this.hundreds >= hdNeeded);
    }

    public boolean isFiEnough(int fftNeeded){
        return (this.fifties >= fftNeeded);
    }

    public boolean isTwEnough(int twNeeded){
        return (this.twenties >= twNeeded);
    }
}