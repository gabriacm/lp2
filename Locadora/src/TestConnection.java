import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestConnection {

	public static void main (String[] args)

	throws Exception {
	    Connection con = DriverManager.getConnection(
	                         "jdbc:postgresql: videolocadora",
	                         "postgresql",
	                         "senacrs");

	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT  FROM cliente");

	    while (rs.next()) {
	    	System.out.println("dados");
	        int x = rs.getInt("telefone");
	        String s = rs.getString("nome");
	    }
}
}    
	