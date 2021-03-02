package emailApplication;
import java.util.Scanner;

public class UpdatePassword {

	public static void main(String[] args) {
		
		System.out.println("Enter your e-mail:");
		Scanner input = new Scanner(System.in);
		String email = input.next();
		System.out.println("Enter your existing password:");
		String pass = input.next();
		
	
		String sql = "SELECT password FROM email_app WHERE email_address = " + email;
		
		
		
		
		
	}
	
}
