package javapvt.lesson10;

public class MyException extends Exception{

    //private String exceptionMessage;


    public void getRussianMessage(int code){
        switch (code){
            case 1:
                System.out.println("Делить на ноль нельзя, увы.");
                break;
            case 2:
                System.out.println("Сегодня и умножать на ноль нельзя, извините.");
        }
    }
}