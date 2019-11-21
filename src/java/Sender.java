import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Sender 
{
    
    public static void PutHDFS(String Path, String hdfs_ip, String hdfs_dir) throws IOException 
    {
        String localPath = Path + "stega.wav";
        
        String uri = "hdfs://" + hdfs_ip + ":9000";
        String hdfsDir = uri + hdfs_dir;
        
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        fs.copyFromLocalFile(new Path(localPath), new Path(hdfsDir));
    }
}

