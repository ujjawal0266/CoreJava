package Project.FilesAccess;

import java.io.File;

public class print implements  FileExplorer{

    @Override
    public void getFromOS(File fs) throws InterruptedException {
        if(!fs.exists()){
            throw new IllegalArgumentException("not valid input ");
        }
        String[] store=fs.list();
        for(String temp:store){
            System.out.println(temp);
        }
    }
}
