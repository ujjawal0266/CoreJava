package Thread;


public class waitNotify {
    static void main() throws Exception {
        person pr=new person();
        Thread a=new Thread(){
            @Override
            public void run() {
                try {
                    pr.get(waitNotify.generateRandom());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread b= new Thread(()->{
            pr.deposit(waitNotify.generateRandom());
        });
        a.start();;b.start();
        a.join();
        b.join();

        System.out.println(pr.DisplayMoney());

    }
    public static int generateRandom(){
        return (int) (Math.random()*1000);
    }
}
class person{
    private int money=0;
    public  synchronized void get(int money) throws InterruptedException {
        while(this.money<money){
            try{
                System.out.println("not have enough money "+this.money+" / "+money);
                wait(1000);
                if(this.money<money){
                    throw new Exception("not enoght money !! sorry ");
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("we get some money "+this.money+" / "+money);
        this.money-=money;
    }
    public synchronized  void deposit(int money){
        System.out.println("added some money "+this.money+" + = "+money);
        this.money+=money;
        notifyAll();
    }
    public int DisplayMoney(){
        return this.money;
    }
}
