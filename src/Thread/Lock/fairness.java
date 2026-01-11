import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class reantrancelock {
    // amking reantrancelock trye it will call equally to all thread does not create any startvation
    Lock lock =new ReentrantLock();
    public void m1() throws InterruptedException {
        lock.lock();

        System.out.println(Thread.currentThread().getName()+" caling ");
        m2();
        Thread.sleep(1000);
        System.out.println("hello ");
    }
    public void m2(){
        lock.lock();
        System.out.println("another method called "+Thread.currentThread().getName());
        lock.unlock();
        lock.unlock();
    }

}
void main() {
    reantrancelock f=new reantrancelock();
    for(int a=0;a<10;a++){
        Thread aa= new Thread(){
            @Override
            public void run() {
                try {
                    f.m1();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        aa.start();
    }
}
