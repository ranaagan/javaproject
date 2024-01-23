package Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Student;
//rename class to Session
public class Session {
	
	public static boolean authenticateUser(Connection conn, String username, String password)throws SQLException{
		String sql = "SELECT password FROM Students WHERE email_address =?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet memberRs = stmt.executeQuery();
		String returnedPass = "";
		while(memberRs.next()) {
			returnedPass = memberRs.getString("password");
		}
		return (returnedPass.equals(password));
	}
	
	public static void setSessionFields(Connection conn, String email, Student student) throws SQLException {
		String sql = "SELECT * FROM Students WHERE email_address ='" + email+"'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		while (result.next()) { 
			  student.setID(result.getInt("ID")); 
			  student.setfName(result.getString("first_name"));
			  student.setlName(result.getString("last_name"));
			  student.seteMail(result.getString("email_address"));
			  student.setPassword(result.getString("password"));
		}
		
	}

}
