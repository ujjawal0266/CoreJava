package oops.Fileio.serializationGames;

import java.io.*;

public class SendFile implements AutoCloseable{
    private static String FilePath="/home/ujjawal/Project/CoreJava/src/oops/Fileio/serializationGames/UserProfile.java";
    private static String whereTOSend="/home/ujjawal/Project/CoreJava/src/cache.txt";
    public void SendObjectToFile(UserProfile us)throws Exception{
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(whereTOSend))){
            oos.writeObject(us);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {

        }



    }
    public UserProfile getUserProfilesFromCaches() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(whereTOSend));
        return (UserProfile)ois.readObject();
    }

    @Override
    public void close() throws Exception {

    }
}
