package FinalProject;

import FinalProject.controller.parsing.ParseXML;
import FinalProject.data.Bus;
import FinalProject.data.Model;
import FinalProject.controller.downloading.Downloader;
import FinalProject.controller.parsing.ParseJSON;
import FinalProject.view.UI;

public class Start {

    public static void main(String[] args) {

        //Скачиваниие файлов с  расписанием
        Downloader.download();

        if (Downloader.isOk){
            //Создание нового расписания
            Model model = new Model();

            try{
                //Парсинг из файла
                model = ParseJSON.parseGson(Downloader.PATH_JSON);
                //model = ParseXML.parseDom(Downloader.PATH_XML);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            // Работа с пользователем
            if(model != null) {
                UI ui = new UI();
                ui.startUI(model);
            }
        }

    }
}
