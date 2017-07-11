package FinalProject.controller;


import FinalProject.controller.formatting.Dates;
import FinalProject.data.Bus;
import FinalProject.data.Model;

import java.util.ArrayList;
import java.util.Comparator;

public class Controller {

    private static Controller controller;
    private static volatile ArrayList<Bus> schedule;
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

    public static ArrayList<Bus> getSchedule() {
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
            case 5:
                break;
            case 1:
                schedule.sort(Comparator.comparing(Bus::getPrice));
                break;
            case 2:
                schedule.sort(Comparator.comparing(Bus::getPrice).reversed());
                break;
            case 3:
                schedule.sort(Comparator.comparing(Bus::getBusNumber));
                break;
            case 4:
                // Вроде та же история, что с Himalaya в тесте. "Instance reference"
                this.getSchedule().sort(Comparator.comparing(Bus::getLocationEnd));
                break;
        }
        printSchedule();
    }

    // Методы поиска
    public void search(int busNumber){
        int i = 0;
        for(Bus b: schedule){
            if (busNumber == b.getBusNumber()) {
                b.printF();
                i++;
            }
        }
        System.out.println("Найдено совпадений: " + i);
    }

    //считаю два одинаковых метода с разными параметрами полиморфизмом. Точка.
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
