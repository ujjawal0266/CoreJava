package oops.inheritance;

public class ISaRelationship {
    public static void main(String[] args){
        Integer a=0;
        a=null;

    }
}
///  is a relationship form by using extends keyword when one class inhertie through the extends keywork then it directly can aceess tha tprotected and public and default keyword varable and method of the inheritance  ok taht is it
class a{
    public void m1(){
        System.out.println("m1 method inside the a classess ");
    }
}
class b extends a{
    static void main() {

    }
}
class bb{
    static void main() {
        System.out.println("hello");
    }
}
