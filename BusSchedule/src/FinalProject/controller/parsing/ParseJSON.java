package FinalProject.controller.parsing;

import FinalProject.controller.downloading.Downloader;
import FinalProject.data.Model;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class ParseJSON {

    public static Model parseGson(String path){

        Model model = null;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            model = gson.fromJson(reader, Model.class);

        } catch (Exception e){
            System.out.println("Ошибка чтения файла." + e.toString());
            //На случай ошибки с парсингом JSON можно попробовать здесь распарсить XML
            model = ParseXML.parseDom(Downloader.PATH_XML);
        }
        return model;
    }
}
