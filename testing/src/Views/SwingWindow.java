package Views;
import javax.swing.*;

import Controllers.SwingWindowViewController;
import Models.Student;
import Utilities.ConnectionFactory;
import Utilities.Session;

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
	
	
	//public static void main(String[] args) {
		public void createWindow() {
		JFrame j = new JFrame("GSU");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);j.setSize(600, 400);
		j.setLocationRelativeTo(null);
		j.setLayout(new FlowLayout());
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel l1 = new JLabel("Username");
		j.add(l1);
		JTextField t = new JTextField(20);
		j.add(t);
		
		JLabel l2 = new JLabel("Password");
		j.add(l2);
		JPasswordField p1 = new JPasswordField(20);
		j.add(p1);
		
		JButton login = new JButton("Login");
		j.add(login);
		j.setVisible(true);
		
		login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e) {
				userName = t.getText();
				password = new String(p1.getPassword());
				controller.receiveStudentInfo(userName, password);
			}

			
		});		
		
		
		
		}
	//}

}
