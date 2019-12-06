package ddbb;

import java.sql.*;
import java.util.Scanner;


import classes.User;
import ddbbcon.*;
import windows.*;

public class RegisterUser
{
	//Conection with ddbb
	static Connect cct= new Connect();
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
	public static void verify() throws SQLException 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Usuario: ");
		String NickName = s.nextLine();
		
		System.out.println("Contraseña: ");
		String password = s.nextLine();
		s.close();
		
		conn= DriverManager.getConnection("jdbc:sqlite:Database/SecuoiaDDBB.db");
		PreparedStatement stmt2 = conn.prepareStatement("SELECT Nickname FROM User WHERE Nickname=? AND Password = ?");
		//PreparedStatement psn = conn.prepareStatement(null); //NickName
		stmt2.setString(1, NickName);
		stmt2.setString(2, password);

		
		ResultSet rs =stmt2.executeQuery();
		if(rs.next()) 
		{
			System.out.println("Login OK");
		} else 
		{
			System.out.println("Error");
		}
	}
	public static void main(String[] args) throws SQLException {
		verify();
	}
}
