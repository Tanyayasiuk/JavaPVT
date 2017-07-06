package FinalProject;

import java.util.Scanner;

/*Надо бы оформить как-то изящнее...
убрать повторения...

* "Я подумаю об этом завтра..."(с)*/

public class UI {

    public void startUI(Root root){

        System.out.print("\nВыберите операцию:\n" +
                "1. Показать все расписание.\n2. Найти маршрут.\n" +
                "0. Завершить работу\n_ ");

        Scanner scanner = new Scanner(System.in);
        int choice = getChoice(scanner);

        while (choice != 0){
            if (choice == 1){
                System.out.print("\n1. по возрастанию цены\n" +
                        "2. по убыванию цены\n" +
                        "3. по номеру маршрута\n" +
                        "4. по месту прибытия\n" +
                        "5. без сортировки\n" +
                        "0. Отмена\n_ ");
                int sortType = getChoice(scanner);
                while (sortType !=0) {
                    root.sort(sortType);
                    System.out.print("\n1. по возрастанию цены\n" +
                            "2. по убыванию цены\n" +
                            "3. по номеру маршрута\n" +
                            "4. по месту назначения\n" +
                            "0. Отмена\n_ ");
                    sortType = getChoice(scanner);
                }
            } else if (choice == 2){
                System.out.print("\nВыберите критерий поиска:\n" +
                        "1. Номер маршрута\n" +
                        "2. Город отправления\n" +
                        "3. Стоимость\n" +
                        "0. Отмена\n_ ");
                int searchType = getChoice(scanner);
                while(searchType != 0){
                    switch (searchType) {
                        case 1:
                            System.out.print("Введите номер маршрута: ");
                            root.search(getChoice(scanner));
                            break;
                        case 2:
                            System.out.print("Введите город отправления: ");
                            root.search(scanner.next());
                            break;
                        case 3:
                            System.out.print("Введите максимальную стоимость (руб.): ");
                            root.searchPrice(getChoice(scanner));
                            break;
                        default:
                            System.out.println("Неизвестный выбор.\n");
                    }
                    System.out.print("\nВыберите критерий поиска:\n" +
                            "1. Номер маршрута\n" +
                            "2. Город отправления\n" +
                            "3. Стоимость\n" +
                            "0. К основному меню\n_ ");
                    searchType = getChoice(scanner);
                }
            } else
                System.out.println("Неизвестный выбор.\n");

            System.out.print("\nВыберите операцию:\n" +
                    "1. Показать все расписание.\n2. Найти маршрут.\n" +
                    "0. Завершить работу\n_ ");
            choice = getChoice(scanner);
        }
        System.out.println("\n...Завершение работы....");
    }


    public static int getChoice(Scanner scanner){
        int choice;
        while (true){
            try {
                choice = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, вводите только числа: ");
            }
        }
        return choice;
    }


}
