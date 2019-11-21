import com.oreilly.servlet.MultipartRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Upload_Servlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String Path = System.getenv("CATALINA_HOME") + "/work/";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        MultipartRequest multipartRequest = new MultipartRequest(request, Path, 64000000, new MyFileRenamePolicy());
        
        PrintWriter writer = response.getWriter();
        String htmlRespone = "<html>";
        htmlRespone += "<h2>File Successfully Uploaded" + "<br/><br/>"; 
        htmlRespone += "Please go back to the previous page to continue INGESTING the data" + "</h2>"; 
        htmlRespone += "</html>";
        writer.println(htmlRespone);
    }
}