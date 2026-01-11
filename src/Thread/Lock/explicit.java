import jdk.jshell.spi.ExecutionControlProvider;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class explicit
{
    private final Lock lock=new ReentrantLock();
    private int amount=0;

    public void Deposit(int amount){
        try{
            if(lock.tryLock(1000,TimeUnit.NANOSECONDS)){
                try{
                    System.out.println("deposit: work started... ");
                    /// database work
                    this.amount+=amount;
                    System.out.println("deposit:   "+amount+"$  work completed ");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                finally{
                    lock.unlock();
                }
            }else{
                System.out.println("deposit: sorry could not found key");
            }
        } catch (Exception e) {
            System.out.println("deposit: interfupped error");
        }
    }
    public void WithDraw(int amount) {
        try {
            if (lock.tryLock(1000, TimeUnit.NANOSECONDS)) {
                try{
                if (amount <= this.amount) {
                        System.out.println("withdrawing: work started... ");
                        this.amount -= amount;
                        System.out.println("withdrawing: " + amount + "$ work completed ");
                }
                else{
                    System.out.println("not enough money");
                }
                }finally {
                    lock.unlock();
                }
            }
        } catch (Exception e) {
            System.out.println("withdrawing: interfupped error ");
        }
    }
}

void main() {
    explicit ep=new explicit();

    for(int a=0;a<10;a++) {
        new Thread(() -> {
            try {
                ep.WithDraw(100);
            } catch (Exception e) {
                System.out.println("withdrawal failed ");
            }
        }).start();

        new Thread(() -> {
            try {
                ep.Deposit(100);
            }catch (Exception e) {
                System.out.println("deposit failed ");
            }
        }).start();
    }
}
