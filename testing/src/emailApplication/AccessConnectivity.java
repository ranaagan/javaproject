package emailApplication;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccessConnectivity {

	public static void main(String[] args) {

		System.out.println("Enter first name, last name, and company");
		
		Scanner input = new Scanner(System.in);	
		String first = input.next();
		String last = input.next();
		String company = input.next();
		
		Email x = new Email(first, last, company);

		
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\raagan\\Desktop\\Java Project\\Database11.accdb");
			String sql = "INSERT INTO email_app (first_name, last_name, company, email_address, password) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, x.getfName());
			preparedStatement.setString(2, x.getlName());
			preparedStatement.setString(3, x.getDomain());
			preparedStatement.setString(4, x.geteMail());
			preparedStatement.setString(5, x.getPassword());
			System.out.println("success");
			
			  int row = preparedStatement.executeUpdate();
			  
			  if (row > 0) { System.out.println("A row has been inserted successfully."); }
			  
			  sql = "SELECT * FROM email_app";
			  
			  Statement statement = connection.createStatement();
			  ResultSet result = statement.executeQuery(sql);
			  
			  
			  while (result.next()) { 
				  int id = result.getInt("ID"); 
				  String fname = result.getString("first_name");
				  String lastname = result.getString("last_name");
				  String c = result.getString("company");
				  String e = result.getString("email_address");
				  String p = result.getString("password");
				  
			  System.out.println(id + ", " + fname + ", " + lastname + ","+ c +"," + e + ", " + p); 
			  }
			 

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}