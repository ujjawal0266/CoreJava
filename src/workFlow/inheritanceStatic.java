package workFlow;

public class inheritanceStatic {
    static void main() {
         child pr =new child();
    }
}
class parent {
    static{
        System.out.println("1 static parent");
    }
    {
        System.out.println("3 instance parent ");
    }
    parent(){
        System.out.println("4 construture parent ");
    }
}
class child extends parent{
    static{
        System.out.println("2 static Child");
    }
    {
        System.out.println("5 instance  Child");
    }
    child(){
        System.out.println("6 construture  Child");
    }
}
