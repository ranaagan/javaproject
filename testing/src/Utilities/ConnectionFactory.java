package Utilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionFactory {
	  public static Connection getConnection(){
		  String systemUser = System.getProperty("user.name");
	      try {
	    	  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	          Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\"+systemUser+"\\Desktop\\Java Project\\Database1.accdb");
	          return connection;
	      } catch (Exception ex) {
	          throw new RuntimeException("Error connecting to the database", ex);
	      }
	    }
	  
	  public static void main(String[] args) {
	        Connection connection = ConnectionFactory.getConnection();
	    }
}


	