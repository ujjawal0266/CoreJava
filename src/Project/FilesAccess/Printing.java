package Project.FilesAccess;

import java.io.File;

public class Printing  implements  FileExplorer{
    @Override
    public void getFromOS(File fs) throws InterruptedException {
        if(fs.isDirectory()){
            String[] s=fs.list();
            if(s==null){
                return;
            }
            for(String s1:s){
                System.out.println(s1);
            }
        }
        else{
            throw new IllegalArgumentException("File not allowed for printing");
        }
    }
}
