package classes;

public class User {
	String nickName;
	String pass;
	String email;
	String address;
	boolean isAdmin;
	
	public User(String nickName, String pass, String email, String address, boolean isAdmin) {
		this.nickName = nickName;
		this.pass = pass;
		this.email = email;
		this.address = address;
		this.isAdmin = isAdmin;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
