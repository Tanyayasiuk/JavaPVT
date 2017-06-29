package  javapvt.FinalProject;
/*
* C JSON все вроде работает тьфу-тьфу-тьфу
* А вот с xml - вопрос как распарсить "внутренности" waypoints и правильно запихать их в String[] объекта*/

public class Main {

    public static void main(String[] args) {
        DownloaderThread downloaderThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();

        downloaderThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloaderThread);

        downloaderThread.start();
        parserThread.start();
    }
}
