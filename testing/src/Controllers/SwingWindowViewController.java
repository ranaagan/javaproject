package Controllers;

import java.awt.CardLayout;
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
	JTextField registrationFirstNameTextField;
	JTextField registrationLastNameTextField;
	static Connection connection = ConnectionFactory.getConnection();
	JTextField userNameTextField;
	JPasswordField passWordField;
	JButton loginButton;
	JButton goToRegistrationPageButton;
	JButton registerButton;
	JButton backToLogin;
	CardLayout cardLayout;
	JPanel container;
	JPanel loginPanel;
	JPanel registerPanel;
	JPanel welcomePage;
	Student currentStudent;

	
	public SwingWindowViewController(SwingWindow window) {
		window.createWindow();
		registrationFirstNameTextField = window.registrationFirstNameTextField;
		registrationLastNameTextField = window.registrationLastNameTextField;
		userNameTextField = window.userNameTextField;
		passWordField = window.passWordField;
		loginButton = window.loginButton;
		goToRegistrationPageButton = window.goToRegistrationPageButton;
		cardLayout = window.cardLayout;
		container = window.container;
		loginPanel = window.loginPanel;
		registerPanel = window.registerPanel;
		welcomePage = window.welcomePage;
		registerButton = window.registerButton;
		backToLogin = window.backToLogin;
		
		currentStudent = new Student();
		addLoginHandler();
		addGoToRegsitrationButtonHandler();
		addRegisterButtonHandler();
		addBackToLoginButtonHandler();
		
		
	}
	
	public void addLoginHandler() {
		loginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				currentStudent.setEmail(userNameTextField.getText());
				currentStudent.setPassword(new String(passWordField.getPassword()));
				
				try{
					boolean isAuthenticateSuccessful = Session.authenticateUser(connection, currentStudent.getEmail(), currentStudent.getPassword());
					if (isAuthenticateSuccessful == true) {
						Session.setSessionFields(connection, null, currentStudent);
					}
					else {
						JOptionPane.showMessageDialog(null, "Error: Failure logging in");
					}
				}catch(Exception ex) {
					System.out.println("invalid");
				}	
				cardLayout.show(container, "3");
			}
		});		
	}
	
	public void addGoToRegsitrationButtonHandler() {
		goToRegistrationPageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(container, "2");
			}
			});
		
	}
	
	public void addRegisterButtonHandler() {
		
		registerButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				Student newstudent = new Student(registrationFirstNameTextField.getText(), registrationLastNameTextField.getText());
			
				try {
					Register.registerUser(connection, newstudent);
					JOptionPane.showMessageDialog(null, "Success, your password is: " + newstudent.getPassword() );
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error: Failure registering student!");
				}
				
			}

			
		});
	}
	
	public void addBackToLoginButtonHandler() {
		backToLogin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				cardLayout.show(container, "1");

			}
		});
	}
	
}
	
	


