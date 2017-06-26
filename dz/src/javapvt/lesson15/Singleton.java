package javapvt.lesson15;

// Свои собственные реализации синглтона пока не придумываются ну вот как-то совсем(

// On Demand Holder
public class Singleton {

    //(только для статических полей класса)
    private Singleton(){

    }

    private static class SingletonHolder {
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }
}


//synchronized
/*
public final class Singleton {
    private static Singleton instance;

    private Singleton(){

    }
    public static synchronized Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
}*/

//double-checked locking
/*
public final class Singleton {
    private static volatile Singleton _instance = null;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (_instance == null)
            synchronized (Singleton.class) {
                if (_instance == null)
                    _instance = new Singleton();
            }
        return _instance;
    }
}*/
