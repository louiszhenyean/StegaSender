import java.io.*;
import java.sql.*;

public class DB_Connection 
{
    public Connection get_connection(String db_name, String db_query, String Path)
    {
        Connection connection = null;

        try
        {
            Connection con;
            try (PrintWriter writer = new PrintWriter(new File(Path + "input_db.txt"))) 
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name,"root","root");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(db_query);

                ResultSetMetaData rsmd = rs.getMetaData();
                int columnS = rsmd.getColumnCount();
                while(rs.next())
                {
                    for(int j=1;j<=columnS;j++)
                    {
                        writer.print(rs.getString(j));
                        if (j!=columnS)
                            writer.print(", ");
                    }
                    writer.print("\n");
                }   
            }
            con.close(); //close connection
        }
        
        catch(FileNotFoundException | ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        
        return connection;
    }
    
    
}