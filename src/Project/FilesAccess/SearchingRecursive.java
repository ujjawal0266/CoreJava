package Project.FilesAccess;

import java.io.File;
import java.util.ArrayList;

public class SearchingRecursive implements FileExplorer {
    private ArrayList<File> result=new ArrayList<>();
    private String SearchingFor;
    SearchingRecursive(String Searching){
        this.SearchingFor=Searching;
    }

    @Override
    public void getFromOS(File fs) throws InterruptedException {
        File[] ss=fs.listFiles();
        if(ss==null){
            return;
        }
        for(File s:ss){
            if(s.isFile()){
                if(s.getName().indexOf(SearchingFor)!=-1){
                    System.out.println(s.getAbsolutePath());
                }
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

            }
        }
    }


}
