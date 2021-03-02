package emailApplication;
public class Email {
	
	private String fName;
	private String lName;
	private String domain;
	private String eMail;
	private int mailBoxCapacity;
	private String password="";
	private String altEmail;
	
	public Email(String name, String last, String company) {
		fName= name;
		lName = last;
		domain = company;
		eMail = name+"."+last+"@"+company +".com";
		password = setDefaultPassword();
		System.out.println("Email created: " + eMail+"\n Your password is: "+ password);
	}
	 public String setDefaultPassword() {
		String source = "abcdefghijklmnopqrstuvwxyz0123456789";
		for (int i =0; i< 8;i++) {
			password = ""+password+source.charAt((int)(Math.random()*36));
		}
		return password;
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
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}
	public void setMailBoxCapacity(int mailBoxCapacity) {
		this.mailBoxCapacity = mailBoxCapacity;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAltEmail() {
		return altEmail;
	}
	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}
}




