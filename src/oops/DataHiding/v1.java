package oops.DataHiding;

import java.util.Scanner;

public class v1 {
    private int a=0;
    public int getA(){
        return a;
    }
    public void incrementA(){
        a++;
    }
    public void decrementA(){
        a--;
    }
    public void resetA(){
        a=0;
    }
    public boolean isaEqualb(int b){
        return (b==a)?true:false;
    }
}
class vThreadSafe{
    private int a=0;
    public synchronized int get(){
        return a;
    }
    public synchronized void Increment(){
        a++;
    }
}
class immutablilities{
    private final int s;
    immutablilities(int t) throws Exception {
        // validation
        if(t<=-1){
            throw new IllegalArgumentException("invalid input");
        }
        this.s=t;
    }
    public int get(){
        return s;
    }
}
// real immultable
class immutable{
    private final int s;
    immutable(int t){
        // validation don't trust user input
        s=t;
    }
    public immutable change(int s){
        return new immutable(s);
    }

    public String toString() {
        return s+" ";
    }
    public int toInteger(){
        return s;
    }
}
// class bank
interface bankContract{
    int TotalAmount();
    void WithDrawing(int amount) throws Exception;
    boolean Deposit(int amount);
}
class bank implements  bankContract{
    private int money=0;
    bank(int initialMoney){
        this.money=initialMoney;
    }
    @Override
    public int TotalAmount() {
        return money;
    }

    @Override
    public void WithDrawing(int amount) throws Exception {
        if(amount>money){
            throw new Exception("not enough Money on account");
        }
        money-=amount;
    }
    @Override
    public boolean Deposit(int amount){
        if(amount<=0){
            try {
                throw new Exception("not valid input");
            }
            catch (Exception e){
                int totalTrial=3;
                int input=0;
                Scanner sc=new Scanner(System.in);
                for(int a=0;a<totalTrial;a++){
                    input=sc.nextInt();
                    if(input>0){
                        Deposit(input);
                    }
                }
            }
            return false;
        }
        money+=amount;
        return true;
    }
}



