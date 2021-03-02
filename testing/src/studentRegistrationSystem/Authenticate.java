package studentRegistrationSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticate {
	
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

}
