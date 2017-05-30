package javapvt.lesson4;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Patient[] patient = new Patient[3];

        // "Создание" пациентов)
        for (int i = 0; i < patient.length; i++){
            patient[i] = new Patient();
            patient[i].fillPatientsProfile(patient[i], i+1);
        }

        //Вывод списка пациентов как в задании
        for (int i= 0; i < patient.length; i++){
            printfProfile(patient[i]);
        }

        //Или так, в "длинном" виде)
        /*for (int i= 0; i < patient.length; i++){
            patient[i].showPatientsProfile();
        }*/

        // Поиск по списку по критериям пользователя
        Scanner scan = new Scanner(System.in);
        System.out.println("\nLooking for someone? (yes/no) ");
        String answer = scan.next();

        while (!answer.equalsIgnoreCase("no")){
            System.out.println("Choose the criteria: surname/age");
            String answer1 = scan.next();
            if (answer1.equalsIgnoreCase("surname")){
                System.out.println("Enter surname for searching: ");
                String surnameSearch = scan.next();
                searching(patient, surnameSearch);
                answer = prompt();
            } else if (answer1.equalsIgnoreCase("age")){
                System.out.println("Enter age for searching: ");
                int age = scan.nextInt();
                searching(patient, age);
                answer = prompt();
            } else {
                System.out.println("Unknown choice.");
                answer = prompt();
            }
        }
        if (answer.equalsIgnoreCase("no"))
            System.out.println("Bye!");

    }


    public static void searching (Patient[] patients, String surname){
        int count = 0;
        for (int i = 0; i < patients.length; i++) {
            if(surname.equalsIgnoreCase(patients[i].surname)) {
                count++;
                printfProfile(patients[i]);
            }
        }
        if (count == 0)
            System.out.println("No patients found");
    }

    public static void searching (Patient[] patients, int age){
        int count = 0;
        for (int i = 0; i < patients.length; i++) {
            if(age == patients[i].age) {
                count++;
                printfProfile(patients[i]);
            }
        }
        if (count == 0)
            System.out.println("No patients found");
    }


    public static void printfProfile(Patient patient){
        System.out.println("Пациент \"" + patient.surname + " " + patient.name + "\" - Возраст = " + patient.age);
    }

    public static String prompt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to continue? (yes/no)");
        String answer = sc.next();
        return answer;
    }

}
