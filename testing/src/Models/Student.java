package Models;

public class Student {
	private static int count = 0;
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String password="";
	
	public Student() {
	}
	
	public Student(String firstName, String lastName) {
		ID = ++count;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = firstName+"."+lastName+"@gsu.edu";
		this.password = createPassword();
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String createPassword() {
		String source = "abcdefghijklmnopqrstuvwxyz0123456789";
		for (int i =0; i< 8;i++) {
			password = ""+password+source.charAt((int)(Math.random()*36));
		}
		return password;
	}
	


}
