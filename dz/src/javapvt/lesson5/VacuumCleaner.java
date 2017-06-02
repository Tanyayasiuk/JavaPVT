package javapvt.lesson5;

/**
 * Created by ОК on 01.06.2017.
 */
public class VacuumCleaner extends MyAppliances {

    private int suctionPower;
    private int numberOfBrushes;

    public int getSuctionPower() {
        return suctionPower;
    }

    public void setSuctionPower(int suctionPower) {
        this.suctionPower = suctionPower;
    }

    public int getNumberOfBrushes() {
        return numberOfBrushes;
    }

    public void setNumberOfBrushes(int numberOfBrushes) {
        this.numberOfBrushes = numberOfBrushes;
    }
}