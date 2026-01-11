package Project.Alarm;

public class main {
    static void main() throws InterruptedException {
        // input
        int minutes;
        int secand;
        System.out.println("Hello your time set - \n Minutes = "+(minutes= Integer.parseInt(IO.readln("Enter Minutes = ")))+"\n Sec  = "+(secand=Integer.parseInt(IO.readln("enter Sec = "))));
        minutes*=100;
        minutes*=1000;
        secand*=1000;


        int finalMinutes = minutes;
        int finalSecand = secand;
        final Thread a= new Thread(){
            int m=0;
            int s=0;
            public  void run(){

                try {
                    while(m!=finalMinutes &&s!= finalSecand){
                    System.out.println(m+":"+s);
                    sleep(1000);
                    s++;
                    if(s>60){
                        s=0;
                        m++;
                    }
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        };
        a.setDaemon(true);
        a.start();
        Thread.sleep(minutes+secand);
        System.out.println("time is up ");
    }

}
