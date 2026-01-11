package oops;

public class abstractInterfaceHasSamemethod {
    static void main() {
        vegitable a=new banana();
        a.add();
    }
}
abstract class fruite{
    public void add(){
        System.out.println("I am fruite add method ");
    }
}
interface vegitable{
    default void add(){
        System.out.println("I am vegitable add method ");
    }
}
class banana extends fruite implements vegitable{

}

