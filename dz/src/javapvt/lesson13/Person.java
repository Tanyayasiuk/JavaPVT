package javapvt.lesson13;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    private int age;
    private int id;
    private boolean isDegree;
    private String name;
    private String surname;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("isDegree")
    public boolean isDegree() {
        return isDegree;
    }

    public void setDegree(boolean degree) {
        this.isDegree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", degree=" + isDegree +
                '}';
    }
}
