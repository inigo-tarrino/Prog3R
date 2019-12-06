package ddbb;

import java.sql.*;

import classes.User;
import ddbbcon.*;
import windows.*;

public class RegisterUser
{
	//Conection with ddbb
	static connect cct= new connect();
	static Connection conn = cct.conect();
	
	
	public static void addUser(User u) 
	{
		String nick = u.getNickName();
		String pass = u.getPass();
		String email = u.getEmail();
		
		String SQL = "INSERT INTO user (NickName, Password, Email) VALUES ('" + nick + "','" + pass + "','" + email + "')";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
}
