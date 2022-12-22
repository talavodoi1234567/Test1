
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class testmysql{  
 public static void main(String[] args)  {
	 Connection conn = null;
	 try {
	     // db parameters
	     String url       = "jdbc:mysql://localhost:3306/test";
	     String user      = "root";
	     String password  = "";
	      
	     // create a connection to the database
	     conn = DriverManager.getConnection(url, user, password);
	     System.out.println("connected");
	     // more processing here
	     // ...  
	 } catch(SQLException e) {
	    System.out.println(e.getMessage());
	 } finally {
	     try{
	            if(conn != null)
	              conn.close();
	     }catch(SQLException ex){
	            System.out.println(ex.getMessage());
	     }
	 }
 }
}