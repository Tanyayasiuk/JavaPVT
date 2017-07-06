package FinalProject;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class ParseJSON {

    public static Root parseGson(String path){

        Root root = null;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            root = gson.fromJson(reader, Root.class);

        } catch (Exception e){
            System.out.println("Ошибка чтения файла." + e.toString());
            //На случай ошибки с парсингом JSON можно попробовать здесь распарсить XML
            //root = ParseXML.parseDom("D:\\JavaOffline\\src\\FinalProject\\bus_schedule.xml");
        }
        return root;
    }
}
