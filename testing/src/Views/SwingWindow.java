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
	public JButton registerNewButton;
	
	JLabel registrationFirstNameLabel;
	public JTextField registrationFirstNameTextField;
	JLabel registrationLastNameLabel;
	public JTextField registrationLastNameTextField;
	JButton register;
	

	String userName;
	String password;
	String firstName;
	String lastName;
	
	public SwingWindowViewController controller;
	
	public String getuserName() {
		return userName;
	}
	
	public String getpassword() {
		return password;
	}
	

	
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
		
		JPanel container = new JPanel();
		JPanel loginPanel = new JPanel();
		JPanel registerPanel = new JPanel();
		JPanel welcomePage = new JPanel();
		
		CardLayout cl = new CardLayout();
		container.setLayout(cl);
		container.add(loginPanel, "1");
		container.add(registerPanel, "2");
		container.add(welcomePage, "3");
		cl.show(container, "1");
		
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
				
		loginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				userName = userNameTextField.getText();
				password = new String(passWordField.getPassword());
				
				cl.show(container, "3");
			}

		});		
			
		registerNewButton = new JButton("Register as a New User");
		loginPanel.add(registerNewButton);
		
			registerNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "2");
			}
			});

		// Registration as new Screen
		registrationFirstNameLabel = new JLabel("First Name");
		registerPanel.add(registrationFirstNameLabel);
		registrationFirstNameTextField = new JTextField(20);
		registerPanel.add(registrationFirstNameTextField);
		
		registrationLastNameLabel = new JLabel("Last Name");
		registerPanel.add(registrationLastNameLabel);
		registrationLastNameTextField = new JTextField(20);
		registerPanel.add(registrationLastNameTextField);
			
		register = new JButton("Register New User");
		registerPanel.add(register);
				JLabel success = new JLabel("You are successfully registered. Your password is: " );
				
			register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				firstName = registrationFirstNameTextField.getText();
				lastName = registrationLastNameTextField.getText();
				
			}

			
		});
		
		JButton backToLogin = new JButton("Back to Login");
		registerPanel.add(backToLogin);
		backToLogin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				cl.show(container, "1");

			}
		});
		
		//Welcome Page
		JLabel welcome = new JLabel("Welcome, ");
		welcomePage.add(welcome);
		
		
		j.add(container);
		j.setVisible(true);
		
		}
}
