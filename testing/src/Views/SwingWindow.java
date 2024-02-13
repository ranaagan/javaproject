package Views;
import javax.swing.*;

import Controllers.SwingWindowViewController;
import Models.Student;
import Utilities.ConnectionFactory;
import Utilities.Session;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SwingWindow {

	JLabel userNameLabel;
	public JTextField userNameTextField;
	JLabel passWordLabel;
	public JPasswordField passWordField;
	public JButton loginButton;
	public JButton goToRegistrationPageButton;
	
	JLabel registrationFirstNameLabel;
	public JTextField registrationFirstNameTextField;
	JLabel registrationLastNameLabel;
	public JTextField registrationLastNameTextField;
	public JButton registerButton;
	public JButton backToLogin;
	
	public JPanel container = new JPanel();
	public JPanel loginPanel = new JPanel();
	public JPanel registerPanel = new JPanel();
	public JPanel welcomePage = new JPanel();
	public CardLayout cardLayout = new CardLayout();

	public void createWindow() {
		JFrame j = new JFrame("Georgia State University");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(800, 200);
		j.setLocationRelativeTo(null);
		//j.setLayout(new FlowLayout());
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		container.setLayout(cardLayout);
		container.add(loginPanel, "1");
		container.add(registerPanel, "2");
		container.add(welcomePage, "3");
		cardLayout.show(container, "1");
		
		//Login Screen
		userNameLabel = new JLabel("Username");
		loginPanel.add(userNameLabel);
		userNameTextField = new JTextField(20);
		loginPanel.add(userNameTextField);
			
		passWordLabel = new JLabel("Password");
		loginPanel.add(passWordLabel);
		passWordField = new JPasswordField(20);
		loginPanel.add(passWordField);
		
		loginButton = new JButton("Login");
		loginPanel.add(loginButton);
			
					
		goToRegistrationPageButton = new JButton("Register as a New User");
		loginPanel.add(goToRegistrationPageButton);
		
		

		// Registration as new Screen
		registrationFirstNameLabel = new JLabel("First Name");
		registerPanel.add(registrationFirstNameLabel);
		registrationFirstNameTextField = new JTextField(20);
		registerPanel.add(registrationFirstNameTextField);
		
		registrationLastNameLabel = new JLabel("Last Name");
		registerPanel.add(registrationLastNameLabel);
		registrationLastNameTextField = new JTextField(20);
		registerPanel.add(registrationLastNameTextField);
			
		registerButton = new JButton("Register New User");
		registerPanel.add(registerButton);
			
		backToLogin = new JButton("Back to Login");
		registerPanel.add(backToLogin);
		
		
		//Welcome Page
		JLabel welcome = new JLabel("Welcome, ");
		welcomePage.add(welcome);
		
		
		j.add(container);
		j.setVisible(true);
		
		}
}
