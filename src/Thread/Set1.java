package Thread;

public class Set1 {
    // yield join sleep
    apple a=new apple();
     void main() throws InterruptedException {
         ap atom=new ap();
         Thread appa =new Thread(atom);
         appa.start();

         System.out.println(a.get());

    }
    class ap implements Runnable{
        @Override
        public void run() {
            a.increment();
        }
    }

}
class apple{
    private int number=0;
    synchronized void increment(){
        this.number+=1;
    }
    synchronized int get(){
        if(number<0){
            Thread.yield();
        }
        return number;
    }
}
