package Project.FilesAccess;

import java.io.File;
import java.io.IOException;

public class createFile implements  FileExplorer{
    @Override
    public void getFromOS(File fs)  {
        try {
            fs.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
