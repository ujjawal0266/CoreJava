package Project.FilesAccess;

import java.io.File;

public class Rename implements FileManipulation{
    @Override
    public void Process(String Path, String ProcessingPath) {
        File fs=new File(Path);
        fs.renameTo(new File(ProcessingPath));
    }
}
