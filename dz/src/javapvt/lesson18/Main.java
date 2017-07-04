package javapvt.lesson18;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {

        MyTest myTest = new MyTest();
        Class clas = myTest.getClass(); //"вытянули" название класса из объекта

        //System.out.println(clas.getSimpleName()); //можно получить имя класса
        // System.out.println(clas.getName());

        //проверить особенности класса
        int mode = clas.getModifiers();

        /*if(Modifier.isPublic(mode)){
            System.out.println("Public class");
        }

        if(Modifier.isAbstract(mode)){
            System.out.println("Abstract class");
        }*/

        // getFields по умолчанию возвращает только паблик переменные
        //getDeclaredFields - все
        Field[] field = clas.getDeclaredFields();
        Method[] methods = clas.getDeclaredMethods();

        // Получаем инфу  о имеющихся методах
        String modeM;
        for (Method m: methods){
            if (m.getModifiers() == 1)
                modeM = "public";
            else if (m.getModifiers() == 2)
                modeM = "private";
            else
                modeM = "undefined"; // чтобы не расписывать другие варианты и чтобы не ругалась, что "might not be initialized"
            System.out.println("method \"" + m.getName() + "\" is " + modeM + " and returns " + m.getReturnType());
        }
        System.out.print("\n");

        //перебираем имеющиеся переменные
        for(Field f: field){
            System.out.println("variable \"" + f.getName() + "\" is of type \"" + f.getType() + "\"");
            f.setAccessible(true);


            //Меняем значение int a
            if(f.getGenericType().getTypeName().equals("int")){
                try{
                    System.out.println("original a = " + f.get(myTest));
                    f.set(myTest, 18);
                    System.out.println("new a = " + f.get(myTest));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Меняем строку
            try {
                Object o = f.get(myTest);
                if(o instanceof String) {
                    System.out.println("Origin: " + (String)o);
                    f.set(myTest, "Hi there!");
                    System.out.println("New string: " + (String) f.get(myTest));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            // Меняем значение private float
            if (f.getGenericType().getTypeName().equals("float"))
                try {
                    System.out.println("old f = " + f.get(myTest));
                    f.set(myTest, 3.60f);
                    System.out.println("new f = " + f.get(myTest));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            System.out.println();
        }

    }
}

