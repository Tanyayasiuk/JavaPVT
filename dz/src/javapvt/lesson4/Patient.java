package javapvt.lesson4;

import java.io.IOException;
import java.util.Scanner;


public class Patient {

    public int age;
    public String surname;
    public String name;
    public boolean isContagious;
    public float temp;


    public void fillPatientsProfile(Patient patient, int number) throws IOException {
        System.out.println("Creating new patient's profile...");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter " + number + " patient's surname: ");
        patient.surname = sc.nextLine();
        System.out.print("Enter patient's name: ");
        patient.name = sc.nextLine();
        System.out.print("Enter patient's age: ");
        patient.age = sc.nextInt();
        System.out.print("Enter patient's temperature (using ','): ");
        patient.temp  = sc.nextFloat();

        System.out.print("Is he/she contagious? (yes/no) ");
        String contag = sc.next();
        if(contag.equalsIgnoreCase("yes"))
            patient.isContagious = true;
        else
            patient.isContagious = false;
        System.out.println("New profile created.\n");

    }


    //full info's output
    public void showPatientsProfile() {
        System.out.println("\nPatient's surname: " + surname);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Temperature: " + temp);
        System.out.println("Contagious: " + isContagious);
    }

}