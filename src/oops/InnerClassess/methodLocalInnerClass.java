package oops.InnerClassess;

public class methodLocalInnerClass {
    int x=1000;
    void main() {
        final int x=10;
        class apple{
            int x=0;
            void main() {
                System.out.println(methodLocalInnerClass.this.x);
            }
        }
    }
}
