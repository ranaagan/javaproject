package Models;

public class Student {
	private static int count = 0;
	private int ID;
	private String fName;
	private String lName;
	private String eMail;
	private String password="";
	
	public Student() {
	}
	
	public Student(String fName, String lName) {
		ID = ++count;
		this.fName = fName;
		this.lName = lName;
		this.eMail = fName+"."+lName+"@gsu.edu";
		this.password = setPassword();
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword() {
		String source = "abcdefghijklmnopqrstuvwxyz0123456789";
		for (int i =0; i< 8;i++) {
			password = ""+password+source.charAt((int)(Math.random()*36));
		}
		return password;
	}
	
	//used when storing password from database to Student object
	public void setPassword(String pass) {
		this.password=pass;
		
	}
	

}
