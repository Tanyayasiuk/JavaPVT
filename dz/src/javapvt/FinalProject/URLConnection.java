package  javapvt.FinalProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection {

    //private static final String LINK = "http://kiparo.ru/t/bus_schedule.xml";

    public static void connect(String link, String pathname) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection)url.openConnection(); // Подключение к url

            //Получаем код ответа (успешно/неуспешно)
            int responseCode = http.getResponseCode();

            //Если успешно
            if(responseCode == HttpURLConnection.HTTP_OK){
                inputStream = http.getInputStream();
                File file = new File(pathname);
                fileOutputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024]; // буфер. размер - ограничивает кол-во скачанного
                int bytesRead = -1; // количество данных, полученных с сайта (может быть меньше размера буфера) -1 возвращает при окончании файла
                while ((bytesRead = inputStream.read(buffer)) != -1){
                    //запись в файл из буфера с начала, только полезную инфу(размер скачанной полезной инфы хранится в байтсрид)
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                if (file.canRead()) {
                    System.out.println("Файл загружен.");
                }
            } else {
                System.out.println(responseCode);
            }


        } catch (Exception e) {
            System.out.println("Error: " + e.toString());;
        } finally { //Надо закрыть стримы (проверив, были ли они вообще открыты)
            try {
                if (inputStream != null)
                    inputStream.close();
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (Exception e){
                System.out.println("Closing error: " + e.toString());
            }
        }
    }
}