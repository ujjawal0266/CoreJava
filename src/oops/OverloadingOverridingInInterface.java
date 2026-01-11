package oops;

public class OverloadingOverridingInInterface extends b implements a{
    @Override
    public void aa(int a) {

    }
    @Override
    public int aa(String a) {
        return 0;
    }
    void main() {
        aa(new StringBuilder("ujjawal "));
    }
}

interface a{
    void aa();
    void aa(int a);
    int aa(String a);
    default void aa(StringBuilder sb){
        System.out.println(sb+" from interface ");
    }
}

abstract class b implements a{
    public void aa(){
        System.out.println("aaple");
    }
    @Override
    public void aa(StringBuilder sb){
        System.out.println(sb+" from abstract ");
    }
}



