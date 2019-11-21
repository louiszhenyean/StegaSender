import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy 
{
    // implement the rename(File f) method to satisfy the 
    // FileRenamePolicy interface contract
    
    public File rename(File f) 
    {
        //Get the parent directory path as in h:/home/user or /home/user
        String parentDir = f.getParent();

        //Get filename without its path location, such as 'index.txt'
        String fname = f.getName();

        //piece together the filename
        fname = parentDir + System.getProperty("file.separator") + "inputaudio.wav";

        File temp = new File(fname);
        
        return temp;
    }
}