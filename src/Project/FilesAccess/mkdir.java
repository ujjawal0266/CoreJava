package Project.FilesAccess;

import java.io.File;

public class mkdir implements  FileExplorer{
    @Override
    public void getFromOS(File fs) throws InterruptedException {
        fs.mkdir();
    }
}
