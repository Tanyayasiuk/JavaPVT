package javapvt.FinalProject;

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
}
