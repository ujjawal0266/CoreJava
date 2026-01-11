package oops.Fileio.serializationGames;

import java.io.IOException;

public class main {
    private static final UserProfile userInfo;

    static{
        UserProfile us;
        try{
            SendFile ss=new SendFile();
            us =ss.getUserProfilesFromCaches();
        } catch (IOException e) {
            // that mean user  profiles is not genreate yet and also did not save on caches
            // new player
            us =new UserProfile("Ujjawal");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        userInfo=us;
    }

    public  static int repeater(String s1){
        System.out.println("Games = "+s1);
        System.out.println(" Press \n (1) next  (2) GameSetToZero (3) exit ?  ");
        int temp=Integer.parseInt(IO.readln());
        return temp;
    }
    static void main() throws Exception {

        ///  first get the UserProfiles from the saved caches and then
        Games rs=new Games();
        SendFile sf=new SendFile();
        rs.setCurrentNumber(userInfo.getLevel());

        while(true){
            int temp=repeater(rs.getNext());
            if(temp==2){
                System.out.println("what to set ? 0 upto "+(rs.gamesLength()-1));
                rs.CurrentNumberSetter(Integer.parseInt(IO.readln()));
            }
            if(temp==3){
                // save session through teh serialization ok
                userInfo.setLevel(rs.getCurrentNumber());
                sf.SendObjectToFile(userInfo);
                // exit the
                break;
            }
        }
    }
}
