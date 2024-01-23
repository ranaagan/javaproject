package Controllers;

import java.sql.Connection;
import java.sql.SQLException;

import Models.Student;
import Utilities.ConnectionFactory;
import Utilities.Session;
import Views.SwingWindow;

public class SwingWindowViewController {
	String username;
	String password;
	static Connection connection = ConnectionFactory.getConnection();

	
	public void createGUI() {
		SwingWindow window = new SwingWindow();
		window.setController(this);
		window.createWindow();
	}
	public void authenticate(String userName, String password) {
		try {
			if (Session.authenticateUser(connection, userName, password)) {
				Student currentStudent = new Student();
				Session.setSessionFields(connection, userName, currentStudent);
				System.out.println("success");
			} 
			else System.out.println("Invalid Credentials");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void receiveStudentInfo(String username, String password) {
		this.username = username;
		this.password = password;
		authenticate(username, password);
	
		
	}

}
