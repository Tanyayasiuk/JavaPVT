package javapvt.lesson8;

import java.text.SimpleDateFormat;
import java.util.*;

public class StudentsBase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество студентов: ");
        int n = sc.nextInt();

        // Создаем массив студентов
        Student[] studentsArray = new Student[n];
        for (int i = 0; i < studentsArray.length; i++){
            studentsArray[i] = new Student();
            System.out.print("Введите фамилию " + (i + 1) + " студента: ");
            studentsArray[i].setSurname(sc.next());
            System.out.print("Введите имя студента: ");
            studentsArray[i].setName(sc.next());
            System.out.print("Введите дату рождения (гггг-мм-дд): ");
            String birthDate = sc.next();                               // Получаем дату рождения в виде строки
            studentsArray[i].setDateOfBirth(stringToDate(birthDate));   // После преобразования записываем в объект
        }

        // Просто распечатка, что получилось
        for (int i = 0; i < studentsArray.length; i++) {
            System.out.print((i + 1) + ": " + studentsArray[i].getSurname() + " " + studentsArray[i].getName());
            System.out.println(" " + new SimpleDateFormat("dd.MM.yyyy").format(studentsArray[i].getDateOfBirth()));
        }

        // Вычисляем и распечатываем средний возраст студентов
        avAge(studentsArray);
    }


    // Преобразует строку в дату
    public static Date stringToDate(String string){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    // Подсчитывает возраст в месяцах (точность не на высшем уровне))
    public static int getAge(Date dateOfBirth){
        GregorianCalendar dateBirth = new GregorianCalendar();
        dateBirth.setTime(dateOfBirth);
        GregorianCalendar now = (GregorianCalendar) GregorianCalendar.getInstance();
        int years = now.get(Calendar.YEAR) - dateBirth.get(Calendar.YEAR);
        int months;
        if (now.get(Calendar.MONTH) < dateBirth.get(Calendar.MONTH)) {
            years--;
            months = 12 - dateBirth.get(Calendar.MONTH) + now.get(Calendar.MONTH);
        } else {
            months = now.get(Calendar.MONTH) - dateBirth.get(Calendar.MONTH);
        }
        int ageInMonths = years * 12 + months;
        return ageInMonths;
    }

    // Считает и печатает средний возраст для всего массива
    public static void avAge(Student[] array){
        int sumAge=0;
        for (int i = 0; i < array.length; i++){
            sumAge += getAge(array[i].getDateOfBirth());
        }
        int avgAgeInMonths = sumAge / array.length;
        System.out.println("Средний возраст: " + avgAgeInMonths / 12 + " лет и " +avgAgeInMonths % 12 + " месяцев.");
    }


}
