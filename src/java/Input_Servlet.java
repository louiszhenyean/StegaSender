import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Input_Servlet extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String Path = System.getenv("CATALINA_HOME") + "/work/";
        
        String db_name = request.getParameter("db_name");
        if (db_name == "") 
            db_name = "something";
        
        String db_query = request.getParameter("db_query");
        if (db_query == "") 
            db_query = "select * from emp;";
        
        String hdfs_ip = request.getParameter("hdfs_ip");
        if (hdfs_ip == "") 
            hdfs_ip = "192.168.113.129";
        
        String hdfs_dir = request.getParameter("hdfs_dir");
        if (hdfs_dir == "") 
            hdfs_dir = "/";
        
        // Database Connection
        DB_Connection trynaConnect = new DB_Connection();
        Connection connection = null;
        connection = trynaConnect.get_connection(db_name, db_query, Path);
        
        // Compression
        Compression_final comp = new Compression_final();
        comp.Compress(Path);

        // Audio Steganography
        Audio_Steganography adSte=new Audio_Steganography();
        try {adSte.AudioSte(Path);} 
        catch (UnsupportedAudioFileException ex) 
        {
            Logger.getLogger(Input_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Forward to HDFS
        Sender sendhdfs = new Sender();
        sendhdfs.PutHDFS(Path, hdfs_ip, hdfs_dir);
        
        // To confirm the input are all getto desu
        PrintWriter writer = response.getWriter();
        String htmlRespone = "<html>";
        htmlRespone += "<h2>db_name: " + db_name + "<br/><br/>"; 
        htmlRespone += "db_query: " + db_query + "<br/><br/>"; 
        htmlRespone += "hdfs_ip: " + hdfs_ip + "<br/><br/>";    
        htmlRespone += "hdfs_dir: " + hdfs_dir + "</h2>"; 
        
        // Check DATABASE connection
        htmlRespone += "My Database Connection Status is: " + connection;
        htmlRespone += "</html>";
        writer.println(htmlRespone);
    }
}
