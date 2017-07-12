package FinalProject.controller;

import FinalProject.controller.sorting.SortByLocation;
import FinalProject.controller.sorting.SortByNumber;
import FinalProject.data.Bus;
import FinalProject.data.Model;
import FinalProject.controller.formatting.Dates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    private static Controller controller;
    private volatile ArrayList<Bus> schedule;
    private String modelsName;
    private String modelsDate;

    private Controller(Model model) {
        schedule = model.getSchedule();
        modelsName = model.getName();
        modelsDate = model.getDate();
    }

    public static Controller getController(Model model) {
        if (controller == null)
            controller = new Controller(model);
        return controller;
    }

    public ArrayList<Bus> getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "\'" +
                modelsName + '\'' +
                "\n" + Dates.dateFormatted(modelsDate) +
                "\n";
    }

    public void printSchedule() {
        System.out.println("\n" + this.toString());
        for (Bus b: schedule){
            b.printF();
        }
    }

    public void sort(int sortType){
        switch (sortType) {
            case 6:
                break;
            case 1:
                //Такой вариант релизации сортировки нравится мне куда больше отдельного класса
                schedule.sort(Comparator.comparing(Bus::getPrice));
                break;
            case 2:
                schedule.sort(Comparator.comparing(Bus::getPrice).reversed());
                break;
            case 3:
                //Но можно и отдельным классом
                Collections.sort(schedule, new SortByNumber());
                break;
            case 4:
                Collections.sort(schedule, new SortByNumber().reversed());
                break;
            case 5:
                Collections.sort(schedule, new SortByLocation());
                //Другой вариант:
                //schedule.sort(Comparator.comparing(Bus::getLocationEnd));
                break;
        }
        printSchedule();
    }

    // Методы поиска
    public void search(int busNumber){
        int i = 0;
        for(Bus b: schedule){
            if (busNumber == b.getNumber()) {
                b.printF();
                i++;
            }
        }
        System.out.println("Найдено совпадений: " + i);
    }

    //считаю два одинаковых метода с разными параметрами полиморфизмом.
    public void search(String locationStart){
        int i = 0;
        for (Bus b: schedule){
            if (locationStart.equalsIgnoreCase(b.getLocationStart())) {
                b.printF();
                i++;
            }
        }
        System.out.println("Найдено совпадений: " + i);
    }

    public void searchPrice (int price){
        int i = 0;
        for (Bus b: schedule){
            if (price >= b.getPrice()){
                b.printF();
                i++;
            }
        }
        System.out.println("Подходящих маршрутов: " + i );
    }
}
