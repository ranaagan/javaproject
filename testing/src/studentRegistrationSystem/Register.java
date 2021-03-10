package studentRegistrationSystem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import studentRegistrationSystem.Student;

import java.sql.Connection;

public class Register {
	
	public static void registerUser(Connection conn, Student x)throws SQLException {
		
		String sql = "INSERT INTO Students (first_name, last_name, email_address, password) VALUES (?, ?, ?, ?)";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, x.getfName());
		preparedStatement.setString(2, x.getlName());
		preparedStatement.setString(3, x.geteMail());
		preparedStatement.setString(4, x.getPassword());
		
		preparedStatement.executeUpdate();
		  		
	}

}
