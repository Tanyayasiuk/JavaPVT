package FinalProject.controller.sorting;

import FinalProject.data.Bus;

import java.util.Comparator;

public class SortByNumber implements Comparator<Bus> {

    @Override
    public int compare(Bus b1, Bus b2) {
        Integer num1 = b1.getNumber();
        Integer num2 = b2.getNumber();

        return num1.compareTo(num2);
    }

}
