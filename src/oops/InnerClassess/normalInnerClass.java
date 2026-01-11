package oops.InnerClassess;

public class normalInnerClass {
    static void main() {
        System.out.println("hello ");
    }
    class apple{
        // no static field
        public void m1(){
           // int x=normalInnerClass.this.x;
            System.out.println("inner class");
        }
    }
}
