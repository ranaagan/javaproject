package Utilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionFactory {
	  public static Connection getConnection(){
	      try {
	    	  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	          Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\ragan\\Desktop\\Java Projects\\Database1.accdb");
	          return connection;
	      } catch (Exception ex) {
	          throw new RuntimeException("Error connecting to the database", ex);
	      }
	    }
	  
	  public static void main(String[] args) {
	        Connection connection = ConnectionFactory.getConnection();
	    }
}


	