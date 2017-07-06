package FinalProject;

import java.util.ArrayList;
import java.util.Comparator;

public class Root {

    private static Root root;

    private Root() {}

    public static Root getInstance() {
        if (root == null)
            root = new Root();
        return root;
    }

    private String name;
    private String date;
    private ArrayList<Bus> schedule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bus> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Bus> schedule) {
        this.schedule = schedule;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "\'" +
                name + '\'' +
                "\n" + Dates.dateFormatted(date) +
                "\n";
    }

    //Распечатывает расписание целиков в удобоваримом виде
    public void printSchedule(){
        System.out.println("\n" + this.toString());
        for (Bus b: schedule){
            b.printF();
        }
    }

    // Методы поиска надо унифицировать, но пока не получилось
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

    // Сортирует расписание в зависимости от выбранного критерия и печатает его
    public void sort(int sortType){
        switch (sortType){
            case 5:
                break;
            case 1:
                this.getSchedule().sort(Comparator.comparing(Bus::getPrice));
                break;
            case 2:
                this.getSchedule().sort(Comparator.comparing(Bus::getPrice).reversed());
                break;
            case 3:
                this.getSchedule().sort(Comparator.comparing(Bus::getBusNumber));
                break;
            case 4:
                this.getSchedule().sort(Comparator.comparing(Bus::getLocationEnd));
                break;
        }
        printSchedule();
    }

}

