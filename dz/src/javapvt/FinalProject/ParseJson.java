package javapvt.FinalProject;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;


public class ParseJson {

    public static Root parseGson(String path){

        Root root = null;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            root = gson.fromJson(reader, Root.class);

        } catch (Exception e){
            System.out.println("Ошибка чтения файла." + e.toString());
        }

        return root;
    }
}
