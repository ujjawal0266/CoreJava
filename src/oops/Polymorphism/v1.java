package oops.Polymorphism;

public class v1 {
    // compile time polymorphism
    // early binding
    // when we have do overloading s tat is called compiled time polymorphism
    public void m1(int a){
        System.out.println("a");
    }
    private void m1(double a)throws Exception{
        System.out.println(a);
    }

}
 class v2 extends v1{
    // run time polymorphism
    // it mean late binding
    /// ithappend wen we use overing annottaion
    // overriding already writen mehtod aagain for getten as per class requirement method reuslt ok
    // here we can
    public void m1(){
        System.out.println("null");
    }
}



