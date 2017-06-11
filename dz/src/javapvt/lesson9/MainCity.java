package javapvt.lesson9;


public class MainCity {
    public static void main(String[] args) {
        City minsk = new City();
        City.Avenue avenue = minsk.new Avenue("Pushkina av.");
        avenue.showAv();
        minsk.setAvenue(avenue);

        City.Street street = minsk.new Street("Lermontova str.");
        minsk.setStreet(street);
        street.showStr();

        City.Square sq = minsk.new Square("Pobedy sq.");
        sq.showSq();
        minsk.setSquare(sq);
        minsk.showAll();  //Прикольненько распечатывает пути (?) и хеш-коды(?) объектов)
    }
}
