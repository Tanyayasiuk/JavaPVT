package javapvt.lesson11;


public class Person {
    private String name;
    private String patronymic;
    private String surname;

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name =name;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
