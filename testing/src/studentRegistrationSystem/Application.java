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
				
			String mainMenu = "yes";
			while (mainMenu.equals("yes")){
			System.out.println("Welcome " +currentStudent.getfName()+", what would you like to do? \n (1)Register for a class \n (2)View my Classes \n (3)Drop existing class");
			int selection = input.nextInt();
			
			switch (selection) {
				
				case 1: 
						System.out.println("Enter the ID of the course you would like to add from below: (Type 0 to quit)");
						CourseRegistration.viewAllCourses(connection);
						int courseSelection = input.nextInt();
						while(courseSelection != 0) {
						CourseRegistration.addCourse(connection, currentStudent, courseSelection);
						System.out.println("Next:");
						courseSelection = input.nextInt();
						}
						break;
			
				case 2: CourseRegistration.viewMyCourses(connection, currentStudent);
						break;
			
				case 3: System.out.println("Enter the IDs of the courses you would like to delete: (Type 0 to quit)");
						CourseRegistration.viewMyCourses(connection, currentStudent);
						int deletedCourse = input.nextInt();
						while(deletedCourse !=0) {
						CourseRegistration.deleteCourse(connection, currentStudent, deletedCourse);
						System.out.println("Next:");
						deletedCourse = input.nextInt();
						}
						break;
			
				default:
						System.out.println("Invalid input");
			}
			System.out.println("Want to return to Main Menu? (Type yes or no to logout)");
			mainMenu = input.next();
			
			}
			}
			else System.out.println("Invalid Credentials");
		}
		else {System.out.println("Enter first name, last name");
			String first = input.next();
			String last = input.next();
			Student student = new Student(first, last);
			Register.registerUser(connection, student);
			System.out.println("Registration Successful. Your password is: "+student.getPassword());
		}
	}
}
