package FinalProject.controller.downloading;

public class Downloader {

    private static final String LINK_XML = "http://kiparo.ru/t/bus_schedule.xml";
    private static final String LINK_JSON = "http://kiparo.ru/t/bus_schedule.json";
    public static final String PATH_JSON = "D:\\JavaOffline\\src\\FinalProject\\controller\\downloading\\bus_schedule.json";
    public static final String PATH_XML = "D:\\JavaOffline\\src\\FinalProject\\controller\\downloading\\bus_schedule.xml";
    public static volatile boolean isOk  ;

    public static void download(){

        System.out.println("Загрузка данных...");

        Thread threadXML = new Thread(new Runnable() {

            @Override
            public void run() {
                isOk = URLConnection.connect(LINK_XML,
                        PATH_XML);
            }
        });

        Thread threadJSON = new Thread(new Runnable() {
            @Override
            public void run() {
                isOk = URLConnection.connect(LINK_JSON,
                        PATH_JSON);
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




