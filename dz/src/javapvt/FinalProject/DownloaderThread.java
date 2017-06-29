package javapvt.FinalProject;

public class DownloaderThread extends Thread {

    private ParserThread parserThread;

    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }

    @Override
    public void run() {

        //скачиваем JSON
        System.out.println("Скачиваем JSON...");
        // Пока так, потом оформлю как-нть толковее эти ссылки
        URLConnection.connect("http://kiparo.ru/t/bus_schedule.json",
                "D:\\JavaOffline\\src\\finalProject\\Downloads\\bus_schedule.json");

        //пробуждаем поток парсера, а сами засыпаем
        synchronized (parserThread) {
            parserThread.notifyAll();
        }
        synchronized(this) {
            //System.out.println("DownloaderThread засыпает");
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        //Теперь черед xml
        System.out.println("Скачиваем XML...");
        URLConnection.connect("http://kiparo.ru/t/bus_schedule.xml",
                "D:\\JavaOffline\\src\\finalProject\\Downloads\\bus_schedule.xml" );

        //пробуждаем поток парсера, затем сами засыпаем
        synchronized (parserThread) {
            parserThread.notifyAll();
            //System.out.println("Завершение работы");
        }
    }
}
