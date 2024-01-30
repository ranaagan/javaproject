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
	
	public void setController(SwingWindowViewController controller) {
		this.controller = controller;
		
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
		JLabel l1 = new JLabel("Username");
		loginPanel.add(l1);
		JTextField t = new JTextField(20);
		loginPanel.add(t);
			
		JLabel l2 = new JLabel("Password");
		loginPanel.add(l2);
		JPasswordField p1 = new JPasswordField(20);
		loginPanel.add(p1);
		
		JButton login = new JButton("Login");
		loginPanel.add(login);
				
			login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				userName = t.getText();
				password = new String(p1.getPassword());
				controller.receiveStudentInfo(userName, password);
				cl.show(container, "3");
			}

		});		
			
		JButton registerNew = new JButton("Register as a New User");
		loginPanel.add(registerNew);
		
			registerNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "2");
			}
			});

		// Registration as new Screen
		JLabel l3 = new JLabel("First Name");
		registerPanel.add(l3);
		JTextField t2 = new JTextField(20);
		registerPanel.add(t2);
		
		JLabel l4 = new JLabel("Last Name");
		registerPanel.add(l4);
		JTextField t3 = new JTextField(20);
		registerPanel.add(t3);
			
		JButton register = new JButton("Register New User");
		registerPanel.add(register);
				JLabel success = new JLabel("You are successfully registered. Your password is: " );
				
			register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				firstName = t2.getText();
				lastName = t3.getText();
				controller.registerStudent(firstName, lastName);
				JOptionPane.showMessageDialog(null, "Success, your password is: " + controller.getPassword() );
				
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
		JLabel welcome = new JLabel("Welcome");
		j.add(container);
		j.setVisible(true);
		
		}
}
