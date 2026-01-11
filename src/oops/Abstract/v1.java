package oops.Abstract;

public class v1 {
}

abstract class Learning{
    int no;
    Learning(int n){
        this.no=n;
    }
    abstract void learn(String subject);
}
class m1 extends Learning{
    m1(int n){
        super(n);
    }
    @Override
    void learn(String sub){
        System.out.println("learned");
    }
}