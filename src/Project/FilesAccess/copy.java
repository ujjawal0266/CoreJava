package Project.FilesAccess;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class copy implements FileManipulation
{
    @Override
    public void Process(String SourceFilePath, String destinationFilePath) {
        File fs=new File(destinationFilePath);

            ///  first create  new file on  destination
                // if not exist then add all text on the target  files
                // if existe then append all  text to the target  file

        // check this sourceFilePath and destinationFIlePath is smae or not
        // if same so precess otherwise
                // if source is file and destination is folder so just create copy file as per the file name and just fill all resource on there ok

        String sfileOrDesName=SourceFilePath.substring(SourceFilePath.lastIndexOf('/')+1);
        String dfileOrDesName= destinationFilePath.substring(destinationFilePath.lastIndexOf('/')+1);
        boolean sTemp=sfileOrDesName.indexOf('.')==-1; // if true so it mean directory
        boolean dTemp=dfileOrDesName.indexOf('.')==-1; // if true so it mean directory
        if(sTemp==dTemp){
            if(sTemp){
                // both are directory
                DirectoryCopy(new File(SourceFilePath),new File(destinationFilePath));
            }
            else{
                // both are files
                try {
                    FilesTransfer(new File(destinationFilePath),new FileReader(new File(SourceFilePath)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else if(sTemp==false&&dTemp){
            File fs1=new File(destinationFilePath);
            if(!fs1.exists()){
                fs1.mkdir();
            }
            fs1=new File(destinationFilePath+"/copy.txt");
            try {
                fs1.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                DirectoryToFile(SourceFilePath,fs1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            throw new IllegalArgumentException(" file and direcotyr not same ");
        }
    }
    private void DirectoryCopy(File fs,File fd){
        // if direcoty is ther eso dont run this ok
    }
    private void DirectoryToFile(String SourceFilePath,File fd) throws IOException {
        PrintWriter pw=new PrintWriter(fd);
        BufferedReader br=new BufferedReader(new FileReader(SourceFilePath));
        String temp;
        while((temp=br.readLine())!=null){
            pw.println(temp);
        }
        pw.flush();
        pw.close();
        br.close();

    }
    private void FilesTransfer(File fd, FileReader fr) throws IOException {
        BufferedReader bf=new BufferedReader(fr);
        try {
            PrintWriter pw=new PrintWriter(fd);
            String temp;
            while((temp=bf.readLine())!=null){
                pw.println(temp);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            bf.close();
        }
    }
}
