public class v1 {

}
interface engine{
    void start();
}
interface os{
    void start();
}
class nenoCar implements  engine,os{
    @Override
    public void start() {
        // here we declare the method we don't inherited from other parent class
    }
}

///  constructure injection
interface OLA{
    void car();
}
class toyota implements OLA{
   @Override
   public void car(){
       System.out.println("omg TOYOTO went to our destination");
   }

}
class honda implements  OLA{
    @Override
    public void car(){
        System.out.println("FUCK OFF HONDA went to my destination");
    }
}

class App{
    private OLA uber;
    App(OLA temp){
        this.uber=temp;
    }

    public void BookRide(){
        uber.car();
    }
}

void main() {
   App a=new App(new toyota());
   a.BookRide();
}
