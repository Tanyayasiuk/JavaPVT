package javapvt.lesson7;

public interface OutputListener {

    public void onGetMoney(Bank bankomat, int result);
    public void onSetMoney(Bank bankomat, boolean result);
}