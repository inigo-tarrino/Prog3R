package classes;

public class User {
	String nickName;
	String pass;
	String email;
	String direccion;
	boolean isAdmin;
	
	public User(String nickName, String pass, String email, String direccion) {
		super();
		this.nickName = nickName;
		this.pass = pass;
		this.email = email;
		this.direccion = direccion;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
