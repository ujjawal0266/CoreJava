package oops.Polymorphism;

public class test11 {

}
enum timeFormat{
    T24Hr(){
        @Override
        public String getTimeFormat(){
            return " 24 hr format";
        }
    },T12Hr {
        @Override
        public String getTimeFormat() {
            return " 12 hr format";
        }
    };
    public abstract String getTimeFormat();

}

interface watch{
    byte MaxBattery=100;
    long showTime() throws Exception;
    void setTime(long newTime);
    byte batteryLevel();
    timeFormat getTimeFormat();
    void charging();
}

class digitalBoatStripe implements watch{
    private long time;
    private timeFormat TIMEFORMAT;
    private byte batteryLevel=0;
    digitalBoatStripe(long time,timeFormat tf,byte BL){
        this.time=time;
        this.TIMEFORMAT=tf;
        this.batteryLevel=BL;
    }
    @Override
    public void setTime(long newTime) {

        this.time=newTime;
    }

    public byte getMaxBatteryPercentage(){
        return watch.MaxBattery;
    }
    @Override
    public long showTime() {
        return time;
    }

    @Override
    public byte batteryLevel() {
        return batteryLevel;
    }

    @Override
    public timeFormat getTimeFormat() {
        return TIMEFORMAT;
    }


    @Override
    public void charging() {
        batteryLevel=100;
    }

}

class milateryGrade implements watch {
    private long time;
    private timeFormat TIMEFORMAT;
    private byte batteryLevel=0;
    milateryGrade(long t,timeFormat tf,byte bl){
        this.time=t;
        this.TIMEFORMAT=tf;
        this.batteryLevel=bl;
    }
    @Override
    public long showTime() throws Exception {
        batteryLevel--;
        if(batteryLevel==0){
            throw new Exception("discharged please charge");
        }
        return time;
    }

    @Override
    public void setTime(long newTime) {
        time=newTime;
    }

    @Override
    public byte batteryLevel() {
        return batteryLevel;
    }

    @Override
    public timeFormat getTimeFormat() {
        return TIMEFORMAT;
    }

    @Override
    public void charging() {
        batteryLevel=100;
    }
}


