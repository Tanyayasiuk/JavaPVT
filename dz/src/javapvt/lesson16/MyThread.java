package javapvt.lesson16;

import static javapvt.dz16.Main.print10;

public class MyThread extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            print10(i, this.getName());
        }
    }
}