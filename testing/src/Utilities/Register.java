package Utilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Student;

import java.sql.Connection;

public class Register {
	
	public static void registerUser(Connection conn, Student student)throws SQLException {
		
		String sql = "INSERT INTO Students (first_name, last_name, email_address, password) VALUES (?, ?, ?, ?)";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, student.getFirstName());
		preparedStatement.setString(2, student.getlastName());
		preparedStatement.setString(3, student.getEmail());
		preparedStatement.setString(4, student.getPassword());
		
		preparedStatement.executeUpdate();
		  		
	}

}
