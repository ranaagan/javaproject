package Utilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Student;

import java.sql.Connection;

public class Register {
	
	public static void registerUser(Connection conn, Student x)throws SQLException {
		
		String sql = "INSERT INTO Students (first_name, last_name, email_address, password) VALUES (?, ?, ?, ?)";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, x.getFirstName());
		preparedStatement.setString(2, x.getlastName());
		preparedStatement.setString(3, x.getEmail());
		preparedStatement.setString(4, x.getPassword());
		
		preparedStatement.executeUpdate();
		  		
	}

}
