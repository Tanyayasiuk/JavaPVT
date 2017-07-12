package FinalProject.controller.sorting;

import FinalProject.data.Bus;

import java.util.Comparator;


public class SortByLocation implements Comparator<Bus> {

    @Override
    public int compare(Bus b1, Bus b2) {
        String destination1 = b1.getLocationEnd();
        String destination2 = b2.getLocationEnd();

        return destination1.compareTo(destination2);
    }
}
