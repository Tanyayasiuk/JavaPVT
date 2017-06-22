package javapvt.lesson14;

import java.util.ArrayList;

public class FileFormat {

    static ArrayList<String> fileList = new ArrayList<>();

    public static void main(String[] args) {

        fileList.add("xml");
        fileList.add("json");

        String fileName = "blablabla.xml";
        checkFormat(getFormat(fileName));
    }

    public static String getFormat(String filename){
        return filename.replaceAll("\\w*\\.", "");
    }

    public static void checkFormat(String format){
        if (fileList.contains(format)) //(format.equals("xml") || format.equals("json"))
            System.out.println("Ok!");
        else
            System.out.println("Unsupported format.");
    }
}
