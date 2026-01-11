package oops.staticFieldAndBLockUse;

//public interface samosa {
//
//    int SamosaPrice=5;\
//    void getMoney();
//    void GiveSamosa();
//    void createNewSamosa();
//}
//interface jalebi{
//    int JalebiPrice=10;
//}
//
//
//
//// taht is not possble because interface has final publci keywork
//class stoleA implements samosa,jalebi{
//    {
//        SamosaPrice=39;
//    }
//}


// way 2  by using abstraction
/*
abstract class samosa{
    static int SamosaPrice=10;
    // and also add some method which is main samosaStore method like getcost()
    // give_samosa();

}

class storeA extends samosa{
    static {
        SamosaPrice=100;
    }
}
*/

// way 3  by uisng simple static block to assing default varble
class StoreA{
    int SamosaPrice=0;
    {
        SamosaPrice=5;
    }
}


