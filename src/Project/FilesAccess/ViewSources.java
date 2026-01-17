package Project.FilesAccess;

import java.io.*;
import java.nio.Buffer;

public class ViewSources  {
    public void View(String ss) throws IOException {
        File sss=new File(ss);
        if(sss.isFile()){
            // files
            BufferedReader br=new BufferedReader(new FileReader(sss));
            String ss1;
            while((ss1=br.readLine())!=null){
                System.out.println(ss1);
            }
        }
        else{
            // directory
            throw new IllegalArgumentException("View Source needed file not directory mf ");
        }
    }
}
