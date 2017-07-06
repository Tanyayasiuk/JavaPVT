package FinalProject;

public class Downloader {

    private static final String LINK_XML = "http://kiparo.ru/t/bus_schedule.xml";
    private static final String LINK_JSON = "http://kiparo.ru/t/bus_schedule.json";
    public static volatile boolean isOk  ;

    public static void download(){

        System.out.println("Загрузка данных...");

        Thread threadXML = new Thread(new Runnable() {

            @Override
            public void run() {
                isOk = URLConnection.connect(LINK_XML,
                        "D:\\JavaPVT\\src\\FinalProject\\bus_schedule.xml" );
            }
        });

        Thread threadJSON = new Thread(new Runnable() {
            @Override
            public void run() {
                isOk = URLConnection.connect(LINK_JSON,
                        "D:\\JavaPVT\\src\\FinalProject\\bus_schedule.json");
            }
        });

        //Параллельно скачиваются файлы в разных форматах
        threadXML.start();
        threadJSON.start();

        //Дожидаемся закрытия потоков скачивания
        try {
            threadJSON.join();
            threadXML.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(isOk){
            System.out.println("Данные загружены.");
        } else
            System.out.println("Ошибка загрузки. Пожалуйста, попробуйте позже.");

    }
}




