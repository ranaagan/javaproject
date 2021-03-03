package studentRegistrationSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {

	static Connection connection = ConnectionFactory.getConnection();
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);	
		System.out.println("Enter 0 to login, 1 to register:");
		if (input.nextInt()==0) {
			System.out.println("Enter username:");
			String uName = input.next();
			System.out.println("Enter password:");
			String pass = input.next();
			
			if (Session.authenticateUser(connection, uName, pass)) {
				Student currentStudent = new Student();
				Session.setSessionFields(connection, uName, currentStudent);
				System.out.println("Welcome " +currentStudent.getfName()+", what would you like to do? \n (1)Register for a class \n (2)View my Classes \n (3)Drop existing class");
			int selection = input.nextInt();
			switch (selection) {
			case 1: CourseRegistration.viewAllCourses(connection);
			System.out.println("Enter the ID of the course you would like to add:");
			int courseSelection = input.nextInt();
			CourseRegistration.addCourse(connection, currentStudent, courseSelection);
			break;
			case 2: CourseRegistration.viewMyCourses(connection, currentStudent);
			break;
			case 3: System.out.println();
			break;
			default:
				System.out.println("Invalid input");
			}
			
			}
			else System.out.println("Invalid Credentials");
		}
		else {System.out.println("Enter first name, last name");
			String first = input.next();
			String last = input.next();
			Student student = new Student(first, last);
			Register.registerUser(connection, student);
		}
	}
}
