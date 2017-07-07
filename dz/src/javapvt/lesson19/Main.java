package javapvt.lesson19;

public class Main {

    public static void main(String[] args) {
        StaffCollection<Worker> contora = new StaffCollection<>();
        Worker w1 = new Worker("Ivanov");
        Worker w2 = new Worker("Petrov");
        Worker w3 = new Worker("Sidorov");
        Worker w4 = new Worker("Fedorov");
        Worker w6 = new Worker("Kovalev");
        Worker w5 = new Worker("D. Sergeev");


        contora.setDirector(w5);

        String dep1 = "One";
        String dep2 = "Two";
        String dep3 = "Three";


        contora.addDepartment(dep1);
        contora.hire("One", w1);
        contora.hire("One", w2);

        contora.addDepartment(dep2);
        contora.hire("Two", w3);

        contora.addDepartment(dep3);
        contora.hire("Three", w4);

        System.out.println(contora.toString());

        contora.fire(dep1, w1);
        System.out.println(contora.toString());

        contora.hire("Four", w6);
        System.out.println(contora.toString());

        contora.removeDepartment(dep2);
        System.out.println(contora.toString());
    }



}
