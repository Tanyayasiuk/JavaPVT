package javapvt.lesson14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoPhoneEmail {

    public static void main(String[] args) {

        // Часть 1 (про авто)
        String text = "2017 AB-7";
        Pattern p = Pattern.compile("\\d{4}\\s\\w{2}-[0-7]");
        Matcher m = p.matcher(text);

        if(m.matches()){
            System.out.println("Right");
        } else{
            System.out.println("Wrong");
        }

        // 2 Про телефон
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер: ");
        String number = scan.nextLine();

        Pattern pat = Pattern.compile("\\+375(\\s?)((17)|(29)|(44)|(33))(\\s?)\\d{7}");
        Matcher mat = pat.matcher(number);

        if (mat.matches()){
            System.out.println("Номер белорусский");
        }else{
            System.out.println("Что-то не так");
        }

        // 3. е-мейлы из  строки
        String text1 = "asghj datr@gmail.com akjyekaby dj tre@ki.com fgret@hy.ry";
        String text2 = text.replaceAll("\\s\\w*@\\w*\\.\\w{0,3}", "");
        System.out.println(text2);
    }
}