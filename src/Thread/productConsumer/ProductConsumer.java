package Thread.productConsumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class ProductConsumer {
    Queue<String> store=new ArrayDeque<>();

        class consumer extends Thread{
            public void run(){
                synchronized (ProductConsumer.this){
                    while (true) {
                        if (store.size() > 0) {
                            System.out.println(store.poll());
                            ProductConsumer.this.notify();
                        } else {
                            try {
                                ProductConsumer.this.wait(10000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if (store.size()==0) {
                                try {
                                    throw new Exception("No more Action");
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
       class producer extends Thread{
           @Override
           public void run() {
               synchronized (ProductConsumer.this){
                   while(true){
                       String task=IO.readln("Enter task = ");
                       store.add(task);
                       ProductConsumer.this.notifyAll();
                       try { ProductConsumer.this.wait(100); } catch (Exception e){}
                   }
               }
           }
       }



     static void main() {
         ProductConsumer pr=new ProductConsumer();
         pr.store.add("ujjawal");
         ProductConsumer.producer producer=pr.new producer();
         ProductConsumer.consumer consumer=pr.new consumer();
         producer.start();
         consumer.start();

        System.out.println("task started ... ");
    }
}

