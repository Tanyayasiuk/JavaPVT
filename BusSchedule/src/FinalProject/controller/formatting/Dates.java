package FinalProject.controller.formatting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Dates {

    public static Date stringToDate(String string){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        Date date = null;
        try {
            date = format.parse(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateFormatted(String dateString){
        return new SimpleDateFormat("EEEEE, dd MMMMM yyyy, HH:mm", Locale.getDefault()).format(stringToDate(dateString));
    }


}
