package oops.InnerClassess;


public class annonomusInnerClass {
    static void main() {

        Runnable r=new Thread(){
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        Thread a=new Thread(r);
        a.start();
        Runnable rr=new Runnable(){
            @Override
            public void run() {
                System.out.println("hello ");
            }
        };
        a=new Thread(rr);
        a.start();

        a=new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("hello ");
            }
        });
        a.start();


    }
}
