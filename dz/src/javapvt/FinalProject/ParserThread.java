package javapvt.FinalProject;

import static finalProject.ParseJson.parseGson;
import static finalProject.ParseXML.parseXML;

/**
 * Ждет, пока скачивается файл, затем парсит его.
 * Потом засыпает и ждет скачки файла другого формата. Парсит его
 */
public class ParserThread extends Thread {

    private DownloaderThread downloaderThread;

    public void setDownloaderThread(DownloaderThread downloaderThread){
        this.downloaderThread = downloaderThread;
    }

    @Override
    public void run() {

        // засыпаем и ждем пока поток downoaderThread не вызовет у нас notify()
        synchronized(this) {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }

        //парсим JSON
        System.out.println("Парсинг json...");
        try {
            Root root = parseGson("D:\\JavaOffline\\src\\finalProject\\Downloads\\bus_schedule.json");
            System.out.println(root.toString());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        synchronized(downloaderThread) {
            //пробуждаем поток скачки
            System.out.println("Продолжение загрузки\n");
            downloaderThread.notifyAll();
        }

        synchronized(this) {
            // затем сами засыпаем
            try {
                wait();
            } catch (InterruptedException ex) {}
        }

        //парсим XML
        System.out.println("Парсинг xml...");
        try {
            Root root1 = parseXML("D:\\JavaOffline\\src\\finalProject\\Downloads\\bus_schedule.xml");
            System.out.println(root1.toString());
        } catch (Exception ex) {ex.getMessage();}


        System.out.println("Завершаем работу");
    }
}
