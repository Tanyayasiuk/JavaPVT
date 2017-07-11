package FinalProject.data;

import FinalProject.controller.formatting.Dates;

import java.util.ArrayList;
import java.util.Arrays;

public class Bus {

    private int id;
    private int busNumber;
    private String locationStart;
    private String locationEnd;
    private int price;
    private String dateStart;
    private String dateEnd;
    private String[] waypoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public String getLocationStart() {
        return locationStart;
    }

    public void setLocationStart(String locationStart) {
        this.locationStart = locationStart;
    }

    public String getLocationEnd() {
        return locationEnd;
    }

    public void setLocationEnd(String locationEnd) {
        this.locationEnd = locationEnd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String[] getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(String[] waypoints) {
        this.waypoints = waypoints;
    }
    public void setWaypoints(ArrayList<String> list) {this.waypoints = list.toArray(new String[0]);}

    @Override
    public String toString() {
        return "Bus{" +
                "id= " + id + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", from: " + locationStart +
                ", to:" + locationEnd +
                ", price=" + price +
                ", start=" + dateStart +
                ", end=" + dateEnd +
                ", with waypoints:" + Arrays.toString(waypoints) +
                '}';
    }

    public void printF(){
        System.out.println("Автобус №: " + busNumber + "\n" +
                " из: " + locationStart +
                " в: " + locationEnd + "\n" +
                " стоимость: " + price + " руб.\n" +
                " отправление: " + Dates.dateFormatted(dateStart) + "\n" +
                " прибытие: " + Dates.dateFormatted(dateEnd) + "\n" +
                " длительность: " + this.getDuration()/3600 + " ч. " + this.getDuration()%3600/60 + " мин.\n" +
                " остановки в пути: " + Arrays.toString(waypoints) +
                "\n====================");
    }

    public long getDuration(){
        long durationSec = (Dates.stringToDate(this.dateEnd).getTime() - Dates.stringToDate(this.dateStart).getTime())/1000;
        return durationSec;
    }


}
