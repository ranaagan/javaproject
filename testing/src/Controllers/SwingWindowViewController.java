package Controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

import Models.Student;
import Utilities.ConnectionFactory;
import Utilities.CourseRegistration;
import Utilities.Register;
import Utilities.Session;
import Views.SwingWindow;

public class SwingWindowViewController {
	
	static Connection connection = ConnectionFactory.getConnection();
	
	JTextField userNameTextField;
	JPasswordField passWordField;
	JButton loginButton;
	JButton goToRegistrationPageButton;
	
	JTextField registrationFirstNameTextField;
	JTextField registrationLastNameTextField;
	JButton registerButton;
	JButton backToLoginButton;
	
	JButton viewMyCoursesButton;
	
	CardLayout cardLayout;
	JPanel container;
	JPanel loginPanel;
	JPanel registerPanel;
	JPanel welcomePanel;
	Student currentStudent;

	public SwingWindowViewController(SwingWindow window) {
		
		window.createWindow();
		userNameTextField = window.userNameTextField;
		passWordField = window.passWordField;
		loginButton = window.loginButton;
		goToRegistrationPageButton = window.goToRegistrationPageButton;
		
		registrationFirstNameTextField = window.registrationFirstNameTextField;
		registrationLastNameTextField = window.registrationLastNameTextField;
		registerButton = window.registerButton;
		backToLoginButton = window.backToLoginButton;
		
		viewMyCoursesButton = window.viewMyCoursesButton;
		
		cardLayout = window.cardLayout;
		container = window.container;
		loginPanel = window.loginPanel;
		registerPanel = window.registerPanel;
		welcomePanel = window.welcomePanel;
		
		currentStudent = new Student();
		addLoginHandler();
		addGoToRegsitrationButtonHandler();
		addRegisterButtonHandler();
		addBackToLoginButtonHandler();	
		addViewMyCoursesButtonHandler();
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
						cardLayout.show(container, "3");
					}
					else {
						JOptionPane.showMessageDialog(null, "Error: Failure logging in");
					}
				}catch(Exception ex) {
					System.out.println("Error");
				}	
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
		backToLoginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				cardLayout.show(container, "1");

			}
		});
	}
	
	public void addViewMyCoursesButtonHandler() {
		
		viewMyCoursesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CourseRegistration.viewMyCourses(connection, currentStudent);
					//testing is session still stored.. its not
					System.out.println(currentStudent.getFirstName());
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
	}
	
}
	
	


