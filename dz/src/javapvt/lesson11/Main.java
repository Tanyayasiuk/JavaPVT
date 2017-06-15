package javapvt.lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // Exercise #1
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Заполните массив. Для выхода нажмите 'q'.");
        String newstring = "";
        int n = 1;

        //Заполнение массива строками
        while (true){
            System.out.print("Введите " + n + " строку: ");
            newstring = scanner.next();

            if (newstring.equalsIgnoreCase("q")) {
                break;
            }
            list.add(newstring);
            n++;
        }

        System.out.println("Ваш массив: " + list.toString());

        //Поиск всех "а" и формирование строк без них
        int index = 0;
        for (String text: list){
            String newtext = "";
            char ch = 'a';
            for (int j = 0; j < text.length(); j++){
                if (text.charAt(j) != ch){
                    newtext += text.charAt(j);
                }
            }
            list.set(index, newtext);
            index++;
        }
        System.out.println("Измененный массив: " + list.toString());

        //Part 2.
        //Теперь надо как-то удалить дубликаты...
        for (int i = 0; i < list.size()-1; i++){
            for (int j = i+1; j < list.size(); j++){
                if (list.get(i).equals(list.get(j))){
                    list.remove(j);
                    j--;
                }
            }
        }
        System.out.println("Только уникальные значения: " + list.toString());

        //Exercise 3
        HashMap<String, ArrayList<Person>> map = new HashMap<>();

        // Наверное, нужно было как-то красивее создание людей навернуть, но как есть)
        ArrayList<Person> men = new ArrayList<>();
        men.add(new Person("Ivanov", "Ivan", "Ivanovich"));
        men.add(new Person("Petrov", "Petr", "Petrovich"));
        men.add(new Person("Fedorov", "Fedor", "Michailovich"));
        men.add(new Person("Sidorov", "Ivan", "Fedorovich"));

        ArrayList<Person> women = new ArrayList<>();
        women.add(new Person("Ivanova", "Irina", "Ivanovna"));
        women.add(new Person("Petrova", "Inga", "Petrovna"));
        women.add(new Person("Sidorova", "Anna", "Ivanovna"));
        women.add(new Person("Fedorova", "Marina", "Dmitrievna"));

        map.put("man", men);
        map.put("woman", women);

        System.out.print("man/woman? ");
        String key = scanner.next();
        try {
            System.out.println(map.get(key).get((int) (Math.random() * (map.get(key)).size())).getSurname());
        } catch(NullPointerException e){
            System.out.println("Ошибка ввода. Вводите только \"man\" или \"woman\".");
        }

    }
}
