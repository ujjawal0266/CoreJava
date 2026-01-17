package Project.FilesAccess;

import java.io.File;

public class Delete implements FileManipulation{
    @Override
    public void Process(String Path, String ProcessingPath) {
        // delete file
        File fs=new File(Path);
        if(fs.isFile()){
            fs.delete();
            System.out.println("deleted = "+fs.getName()); 
        }
        else{
            File[] ss=fs.listFiles();
            if(ss==null){
               fs.delete();
                return;
            };
            for(File s1:ss){
                if(s1.isFile()){
                    s1.delete();
                    System.out.println("deleted = "+s1.getName());
                }else{
                    Process(s1.getPath(),null);
                }
            }
            fs.delete();
            System.out.println("deleted = "+fs.getName());
        }
    }
}
