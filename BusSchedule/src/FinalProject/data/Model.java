package FinalProject.data;

import java.util.ArrayList;

public class Model {

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


}

