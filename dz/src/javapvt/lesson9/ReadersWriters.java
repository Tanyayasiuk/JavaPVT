package javapvt.lesson9;

import java.io.*;

public class ReadersWriters {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("D:\\newdoc.txt")){
            int c;
            while ((c = reader.read()) != -1){
                System.out.print((char)c);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        try (FileWriter writer = new FileWriter("D:\\newdoc.txt", true)){
            writer.append('\n');
            writer.write(" Check writing to file.");
            writer.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }




}
