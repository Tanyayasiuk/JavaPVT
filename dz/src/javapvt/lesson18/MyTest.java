package javapvt.lesson18;


public class MyTest {

    private int a = 6;
    private String text = "text";
    private float f = 24.0f;

    public void testPublic(){
        System.out.println("testPulic");
    }

    private void testPrivate(){
        System.out.println("testPrivate");
    }

    private float getF(){return f;}

    public int getA() {
        return a;
    }

    private String getText() {
        return text;
    }
}
