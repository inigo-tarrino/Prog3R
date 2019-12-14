package ddbb;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
		
		try {
		int ad;
		if(!u.isAdmin()){
			ad = 0;
		}else {
			ad = 1;
		}
		Statement stmt = conn.createStatement();
		String SQL = "INSERT INTO user (NickName, Password, Email, Admin) VALUES ('" + nick + "','" + pass + "','" + email + "','" + ad + "')";
		stmt.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public static boolean searchUser(User u) throws SQLException {
		String SQL = "SELECT Nickname, Password FROM user WHERE Nickname= ? AND Password= ?";
		PreparedStatement stmt = conn.prepareStatement(SQL);
		try {
			stmt.setString(1, u.getNickName());
			stmt.setString(2, u.getPass());
			stmt.executeQuery();
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				if (u.getNickName().equals(rs.getString("Nickname"))) {
					System.out.println("User exists");
					if (u.getPass().equals(rs.getString("Password"))) {
						System.out.println("Password correct");
						return true;
					}else {
						System.out.println("password incorrect");
						return false;
					}
				}else {
					System.out.println("User does not exist");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public static User completeUser(User user) {
		String SQL = "SELECT * FROM user";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				System.out.println(rs.getString(1));
				if (user.getNickName().equals(rs.getString("Nickname"))) {
					System.out.println("User exists");
					if (user.getPass().equals(rs.getString("Password"))) {
						System.out.println("Password correct");
						user.setEmail(rs.getString("Email"));
						user.setAddress(rs.getString("Adress"));
						user.setCreditCard(rs.getString("CreditCard"));
						return user;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return user;
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
