package javapvt.lesson14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compression {

    public static void main(String[] args) {

        String text = "hellowoooorld";
        Pattern pattern = Pattern.compile("([a-z])\\1+");
        Matcher match = pattern.matcher(text);

        while (match.find()) {
            String part = text.replaceAll(text, match.group(0));;
            int count = part.length();
            text = text.replaceFirst("([a-z])\\1+", ("$1" + count));
        }
        System.out.println(text);
    }
}