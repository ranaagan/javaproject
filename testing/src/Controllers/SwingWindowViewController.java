package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

import Models.Student;
import Utilities.ConnectionFactory;
import Utilities.Register;
import Utilities.Session;
import Views.SwingWindow;

public class SwingWindowViewController {
	String username;
	String password;
	String firstName;
	String lastName;
	static Connection connection = ConnectionFactory.getConnection();
	JTextField userNameTextField;
	JPasswordField passWordField;
	JButton loginButton;
	JButton registerButton;
	
	Student currentStudent;
	
	public SwingWindowViewController(SwingWindow window) {
		window.createWindow();
		userNameTextField = window.userNameTextField;
		passWordField = window.passWordField;
		loginButton = window.loginButton;
		registerButton = window.registerNewButton;
		currentStudent = new Student();
		
	}
	
	public void loginHandler() {
		loginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				currentStudent.setEmail(userNameTextField.getText());
				currentStudent.setPassword(new String(passWordField.getPassword()));
				
				
			//	cl.show(container, "3");
			}

		});		

		
	}
	
		
	
	/*public void authenticate(String userName, String password) {
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
	//why do we need this below method and cant call authenticate above directly from the SwignWindow instead? seems repetitive?
	public void receiveStudentInfo(String username, String password) {
		this.username = username;
		this.password = password;
		authenticate(username, password);
			
	}
	
	public void registerStudent(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		Student currentStudent = new Student(firstName, lastName);
		try {
			Register.registerUser(connection, currentStudent);
			this.password = currentStudent.getPassword();
			
		}catch (SQLException e1) {
				e1.printStackTrace();
			}
		}*/
}
	
	


