package sealedClasses;

public class main {

    static void main() {
        penguines a=new penguines("penguine",new swimming());
        a.getMoveable();
    }
}

class Animal{
     void sleep(){
         System.out.println("sleepable");
     }
     void eat(){
         System.out.println("eatable");
     }
}
class bird extends Animal{
    void fly(){
        System.out.println("flyable");
    }
}
class penguine extends bird{
    @Override
    void fly() {
        throw new IllegalArgumentException();
    }
}

interface moveAble{
    void move();
}
class running implements  moveAble{

    @Override
    public void move() {
        System.out.println("running ");
    }
}

class swimming implements moveAble{

    @Override
    public void move() {
        System.out.println("swimming");
    }
}
class flying implements  moveAble{
    @Override
    public void move() {
        System.out.println("flying ");
    }
}


class penguines{
    private String name;
    private moveAble move;

    public penguines(String name, moveAble move) {
        this.name = name;
        this.move = move;
    }
   public void getMoveable(){
        move.move();
    }
}

