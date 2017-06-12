package javapvt.lesson10;

public class Students {
    private String name;
    private int age;
    private boolean isZaochnik;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setZaochnik(boolean zaochnik) {
        isZaochnik = zaochnik;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isZaochnik() {
        return isZaochnik;
    }


    public void show(){
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("IzZaochnik: " + String.valueOf(this.isZaochnik()));
    }
}
