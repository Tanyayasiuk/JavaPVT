package javapvt.lesson8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) throws ParseException {

        // 3-RD exercise
        Date date = new Date();
        Calendar present = Calendar.getInstance();
        present.setTime(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("", Locale.US);
        switch (present.get(Calendar.DAY_OF_MONTH) % 10) {
            case 1:
                dateFormat.applyPattern("MMMM d'st', h:mm a");
                break;
            case 2:
                dateFormat.applyPattern("MMMM d'nd', h:mm a");
                break;
            case 3:
                dateFormat.applyPattern("MMMM d'rd', h:mm a");
                break;
            default:
                dateFormat.applyPattern("MMMM d'th', h:mm a");
                break;
        }
        System.out.println(dateFormat.format(date));


        // 4. String to Date
        String dateString = "2017-06-05 20:25";
        String pattern = "yyyy-MM-dd hh:mm";
        Date dateDate = stringToDate(dateString, pattern);
        System.out.println(new SimpleDateFormat("yyyy MMMM d, h:mm a", Locale.US).format(dateDate));
    }

    public static Date stringToDate(String string, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}