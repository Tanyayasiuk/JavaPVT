package javapvt.lesson13;

import java.util.ArrayList;

public class Root {

    private String name;
    private ArrayList<Person> person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Person> getPerson() {
        return person;
    }

    public void setPeople(ArrayList<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}