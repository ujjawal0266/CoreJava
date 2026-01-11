package Thread;

public class lowPriorityThreadSkips {
    static void main() {

        for(int a=0;a<100;a++){
            Thread aa=new Thread(()->{
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Thread.yield();
                System.out.println("Low priority = "+Thread.currentThread().getPriority());
            });
            aa.setPriority((int)(Math.random()*10+1));
            aa.start();
        }




    }

}
