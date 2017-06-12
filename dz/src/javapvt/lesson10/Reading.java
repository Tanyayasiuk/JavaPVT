package javapvt.lesson10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reading {

    public static void main(String[] args) {

        String s;
        String[] sArray;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("D:\\new.txt"));
            while ((s = reader.readLine()) != null) {
                sArray = s.split("\\|");
                Students student = new Students();
                student.setName(sArray[0]);
                student.setAge(Integer.valueOf(sArray[1]));
                student.setZaochnik(Boolean.valueOf(sArray[2]));
                student.show();
            }
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}



