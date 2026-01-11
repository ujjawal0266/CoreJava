package oops.Fileio;

import java.io.*;

public class GetFeatchMT5GBData {
    static void main()throws IOException {
        File fs=new File("/home/ujjawal/Project/Target/sample_log_files/Andriod/Android_2k.log");
        FileInputStream fis=new FileInputStream(fs);
        InputStreamReader is=new InputStreamReader(fis);
        BufferedReader ffss= new BufferedReader(is);
        String temp=ffss.readLine();
        int count=0;
        while(temp!=null){
            int data=temp.indexOf("DisplayPowerController");
            if(data!=-1){
                count++;
            }
            temp=ffss.readLine();
        }
        System.out.println("All complete  and total count = "+count);
    }
    
}
