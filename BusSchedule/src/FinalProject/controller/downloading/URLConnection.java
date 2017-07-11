package FinalProject.controller.downloading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection {


    public static boolean connect(String link, String path) {
        boolean isSuccess = false;
        //Новые стримы чтения и записи в файл
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            // Подключение к url
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            //Получаем код ответа (успешно/неуспешно)
            int responseCode = http.getResponseCode();

            //Если успешно
            if(responseCode == HttpURLConnection.HTTP_OK){
                inputStream = http.getInputStream();
                File file = new File(path);
                fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024]; // буфер. размер - ограничивает кол-во скачанного
                int bytesRead = -1; // количество данных, полученных с сайта (может быть меньше размера буфера) -1 возвращает при окончании файла
                while ((bytesRead = inputStream.read(buffer)) != -1){
                    //запись в файл из буфера, с начала
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                if (file.canRead()) {
                    isSuccess = true;
                }
            } else {
                System.out.println(responseCode);
            }
        } catch (Exception e) {
            //System.out.println("Error: " + e.getMessage());
        } finally { //Закрыть стримы (проверив, были ли они вообще открыты)
            try {
                if (inputStream != null)
                    inputStream.close();
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (Exception e){
                System.out.println("Closing error: " + e.toString());
            }
        }
        return isSuccess;
    }
}
