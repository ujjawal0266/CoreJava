package Project.FilesAccess;

import java.io.*;

public interface FileExplorer {
    // file search as per given directory ok
    void getFromOS(File fs) throws InterruptedException;
}
