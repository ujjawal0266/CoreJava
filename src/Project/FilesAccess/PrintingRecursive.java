package Project.FilesAccess;

import java.io.File;

public class PrintingRecursive implements  FileExplorer{

    @Override
    public void getFromOS(File fs) throws InterruptedException {
        File[] ss=fs.listFiles();
        if(ss==null){
            return;
        }
        for(File s:ss){
            if(s.isFile()){
                System.out.println(" "+s.getPath()+" "+s.getName());
            }
            else{
                Thread a=new Thread(){
                    @Override
                    public void run() {
                        try {
                            getFromOS(s);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                a.start();
                a.join();
            }
        }
    }


}
