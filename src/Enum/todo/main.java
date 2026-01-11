package Enum.todo;

import java.util.EnumMap;

public class main {
    System.Logger log=System.getLogger("todo Logger ");
    EnumMap<Day,String> store=new EnumMap<>(Day.class);

    public void InsertData(){
        log.log(System.Logger.Level.INFO," Insert Data ");
        store.put(Day.Mon,"Springboot");
        store.put(Day.Tue,"coreJava");
        store.put(Day.Wed,"spring");
        store.put(Day.thurs,"hibernate");
        store.put(Day.fri,"jsp");
        store.put(Day.Satur,"servlet");
        store.put(Day.Sun,"jdbc");
    }

    public void repeater(){
        System.out.println("what do you want ? \n");
        System.out.println(" 1 insert   2 update  3 get ");
        int io=Integer.parseInt(IO.readln());
        boolean temp=false;
        switch (io){
            case 1:{
                InsertData();
                log.log(System.Logger.Level.DEBUG,"Data inserted ! ");
                break;
            }
            case 2:{
                int count=0;
                for(Day a:Day.values()) {
                    System.out.println(" for " + a + " press " + count);
                }
                int a=Integer.parseInt(IO.readln());

                Integer.parseInt(IO.readln("which data do you want to repeat"));
                break;
            }
        }
    }

    private boolean UpdateData(Day day, String java) {
        return false;
    }

    static void main() throws Exception {

    }

}
