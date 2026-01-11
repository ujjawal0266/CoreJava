class main{
    static void main(){
//        parent pr=new child(); // steps memory allocation //
//        System.out.println("wtih the child reference");

    }
}


 // sealed clasess



/*
abstract class parent{
    parent(){
        System.out.println(returnFinalVarableData());
        System.out.println(returnNonFinalVarableData());
    }
    abstract int returnFinalVarableData();
    abstract int returnNonFinalVarableData();
}
class child extends parent{

    final int temp=10;
    int temp2;
    child(){
        // here constrcture are working
        temp2=10;
    }
    @Override
    int returnFinalVarableData() {
        return temp;
    }

    @Override
    int returnNonFinalVarableData() {
        return temp2;
    }
}*/
