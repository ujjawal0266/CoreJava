package Project.FilesAccess;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Move implements FileManipulation{

    @Override
    public void Process(String Path, String ProcessingPath) {
        this.Standerd(Path,ProcessingPath);
    }
    private void Standerd(String Path,String ProcessingPath){
        // folloe the stander and Piped stream copy ok
        Path source= Paths.get(Path);
        Path target=Paths.get(ProcessingPath);
        try{
            System.out.println();
            System.out.println(" 1 StandardCopyOption.ATOMIC_MOVE \n 2 StandardCopyOption.COPY_ATTRIBUTES \n 3 StandardCopyOption.REPLACE_EXISTING ");
            int temp= Integer.parseInt(IO.readln("Enter Number = "));
            CopyOption os;
            switch (temp){
                case 1: os=StandardCopyOption.ATOMIC_MOVE;
                break;
                case 2: os=StandardCopyOption.COPY_ATTRIBUTES;
                break;
                case 3: os=StandardCopyOption.REPLACE_EXISTING;
                break;
                default: throw new Exception("fuck you you didi fucked up ");
            }
            Files.move(source,target,os);
        } catch (IOException e) {
            System.out.println("Error on Move Standerd Method process ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void manuall(String Path,String ProcessingPath){

    }
}

