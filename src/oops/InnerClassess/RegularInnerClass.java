package oops.InnerClassess;

public class RegularInnerClass {
    class fruite {
        class apple{

            int totalProfilt=0;  // this will give me total profilt after selling whole apple
            int totalStock;   // total apple stock
            int Price;          // price to each apple
            boolean neededRefillStock;
            apple(int ts,int price){
                this.totalStock=ts;
                this.Price=price;
                if(totalStock==0){
                    neededRefillStock=true;
                }
                else{
                    neededRefillStock=false;
                }
            }
            public void FillStock(){
                totalStock=20;
            }
            public int getApplePrice(){
                return Price;
            }
            public int getTotalStock() {
                return totalStock;
            }
            public boolean isNeededRefillStock(){
                return neededRefillStock;
            }
            public void removeOne(){
                if(totalStock<=0){
                    neededRefillStock=true;
                    System.out.println("need refill ");
                    boolean temp=Boolean.parseBoolean(IO.readln());
                    if(temp){
                        FillStock();
                        totalStock-=1;
                        totalProfilt+=9;
                    }
                }
                else{
                    totalStock-=1;
                    totalProfilt+=9;
                }
            }
        }
    }
     void main() {
         fruite.apple a=new fruite().new apple(2,9);
         a.removeOne();
         a.removeOne();
         a.removeOne();
         System.out.println(a.getTotalStock());
         ;

    }
}
