package Thread;

import oops.InnerClassess.annonomusInnerClass;

class Thread1 extends Thread{

    static Thread tempTread;
    @Override
    public void run() {
        try {
            tempTread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hello by demon Tread");
    }
}
public class mainTreadWaitForDemonTreads {
    void main() throws InterruptedException {
       Thread1.tempTread=Thread.currentThread();
       Thread1 a=new Thread1();
       a.setDaemon(true);
       a.start();

       // holy moly main thread waiting for demon thread
        Thread.sleep(10000);
        System.out.println("hello by amin thread ");

    }

}
