package javapvt.lesson13;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;

public class Jackson {
    public static void main(String[] args) {
        Root root;
        ObjectMapper map = new ObjectMapper();

        try {
            root = map.readValue(new FileInputStream("test.json"), Root.class);
            System.out.println(root.toString());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
